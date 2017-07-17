package com.baoquan.shuxin.third.util.cfca;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.baoquan.shuxin.config.product.api.CfcaConfig;

/**
 * Created by Administrator on 2017/5/5.
 */
public class HttpUtils {
    private static Logger logger = Logger.getLogger(HttpUtils.class);

    public final static String UTF_8 = "UTF-8";
    /**
     * 加密密钥的密钥
     */
    private String homeKey;

    /**
     * 生产环境地址
     */
    private String urlPrefix;

    /**
     * 测试环境地址
     */
//    private String urlPrefix = "https://210.74.42.39/dataservice";

    /**
     * 异步获取结果，默认休眠时间
     */
    private int defaultSleepTime;

    /**
     * 异步轮训结果尝试次数
     */
    private int asyncGetResultTryCount;

    /**
     * 用户账号
     */
    private String USER_ACCOUNT_ID;

    /**
     * 用户秘钥
     */
    private String userAccountKey;

    public HttpUtils(CfcaConfig cfcaConfig) {
        this.homeKey = cfcaConfig.getCfcaHomeKey();
        this.urlPrefix = cfcaConfig.getCfcaUrlPrefix();
        this.defaultSleepTime = cfcaConfig.getCfcaDefaultSleepTime();
        this.asyncGetResultTryCount = cfcaConfig.getCfcaAsyncGetResultTryCount();
        this.USER_ACCOUNT_ID = cfcaConfig.getCfcaUserAccountId();
        this.userAccountKey = cfcaConfig.getCfcaUserAccountKey();
    }

    public String getHomeKey() {
        return homeKey;
    }

    /**
     * 明文传输同步返回交易
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param params          请求接口body部分参数
     * @return
     * @throws Exception
     */
    public Map requestNotEncryptSync(String transactionCode, String urlSuffix, Map<String, String> params)
            throws Exception {
        return sendRequest(transactionCode, urlSuffix, params, false, true);
    }

    /**
     * 传输同步返回交易
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param params          请求接口body部分参数
     * @return
     * @throws Exception
     */
    public Map requestEncryptSync(String transactionCode, String urlSuffix, Map<String, String> params)
            throws Exception {
        return sendRequest(transactionCode, urlSuffix, params, true, true);
    }

    /**
     * 明文传输异步返回交易
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param params          请求接口body部分参数
     * @param sleepTime       获取结果休眠时间, 默认5秒钟
     * @return
     * @throws Exception
     */
    public Map requestNotEncryptedAsync(String transactionCode, String urlSuffix, Map<String, String> params,
            int... sleepTime) throws Exception {
        return sendRequest(transactionCode, urlSuffix, params, false, false, sleepTime);
    }

    /**
     * 测试加密传世异步返回交易
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param params          请求接口body部分参数
     * @param sleepTime       获取结果休眠时间, 默认5秒钟
     * @return
     * @throws Exception
     */
    public Map requestEncryptAsync(String transactionCode, String urlSuffix, Map<String, String> params,
            int... sleepTime) throws Exception {
        return sendRequest(transactionCode, urlSuffix, params, true, false, sleepTime);
    }

    /**
     * 交易方法
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param params          请求接口body部分参数
     * @param encryptFlag     是否加密接口 true为加密接口，false为明文接口
     * @param syncFlag        是否为同步接口，true为同步接口，false为异步接口
     * @param sleepTime       获取结果休眠时间, 默认5秒钟
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Map sendRequest(String transactionCode, String urlSuffix, Map<String, String> params, boolean encryptFlag,
            boolean syncFlag, int... sleepTime)
            throws Exception {
        logger.info("------------------提交任务----------------------");
        long start = System.currentTimeMillis();

        Map request = new LinkedHashMap<String, Object>();

        Map head = new LinkedHashMap();
        head.put("transactionID", UUID.randomUUID().toString().replace("-", ""));
        head.put("transactionCode", transactionCode);
        head.put("action", "0");
        head.put("chanel", "0");
        head.put("userAccountID", USER_ACCOUNT_ID);
        head.put("authorizationID", "11111111"); // 业务查询授权号
        request.put("head", head);

        Map body = new HashMap<String, String>(params);
        String bodyJson = JsonUtils.obj2Json(body);
        logger.info("encrypt source:" + bodyJson);
        request.put("body", encryptFlag ? EncryptUtils.encryptWithAES(bodyJson, this.userAccountKey) : body);
        String temp = JsonUtils.obj2Json(request);
        String hashSource = temp.substring(1, temp.length() - 1);
        logger.info("hashSource:" + hashSource);
        request.put("hashValue", HashUtils.hashWithSHA256(hashSource));
        String urlStr = urlPrefix + "/" + urlSuffix;
        logger.info(urlStr);
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(urlStr);
        String requestStr = JsonUtils.obj2Json(request);
        logger.info("request:" + requestStr);

        StringRequestEntity requestEntity = new StringRequestEntity(requestStr, "application/json", UTF_8);
        postMethod.getParams().setContentCharset(UTF_8);
        postMethod.setRequestEntity(requestEntity);
        httpClient.executeMethod(postMethod);
        logger.info(System.currentTimeMillis() - start);
        logger.info("response code:" + postMethod.getStatusCode());
        InputStream inputStream = postMethod.getResponseBodyAsStream();
        String responseStr = IOUtils.toString(inputStream, "UTF-8");
        logger.info("response:" + responseStr);
        postMethod.releaseConnection();
        Map response = JsonUtils.json2Obj(responseStr, Map.class);
        Map responseBody = null;
        if ("00000".equals(((Map) response.get("head")).get("code"))) {
            responseBody = encryptFlag ? JsonUtils.json2Obj(
                    EncryptUtils.decryptWithAES((String) response.get("body"), this.userAccountKey), Map.class)
                    : (Map) (response.get("body"));
            logger.info("response body:" + responseBody);
        } else {
            return null;
        }
        if (syncFlag) {
            return responseBody;
        }
        String orderID = (String) responseBody.get("orderID"); // 异步接口提交任务回执

        responseBody = null;

        responseBody = asyncGetResult(transactionCode, urlSuffix, encryptFlag, orderID, sleepTime);
        return responseBody;
    }

    /**
     * 异步轮询结果
     * @param transactionCode 接口编码
     * @param urlSuffix       接口url后缀部分，如申请秘钥接口为apply-for-key.json
     * @param encryptFlag     是否加密接口 true为加密接口，false为明文接口
     * @param orderID         异步提交任务回执
     * @param sleepTime       获取结果休眠时间, 默认5秒钟
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Map asyncGetResult(String transactionCode, String urlSuffix, boolean encryptFlag, String orderID,
            int... sleepTime) throws Exception {

        Map responseBody = null;
        HttpClient httpClient = new HttpClient();

        while ((responseBody == null || responseBody.get("result") == null) && (asyncGetResultTryCount-- > 0)) {

            Thread.sleep(sleepTime != null && sleepTime.length > 0 ? sleepTime[0] : defaultSleepTime);
            long start = System.currentTimeMillis();

            logger.info("------------------获取结果----------------------");
            Map request = new LinkedHashMap<String, Object>();
            Map head = new HashMap<String, String>();
            head.put("transactionID", UUID.randomUUID().toString().replace("-", ""));
            head.put("transactionCode", transactionCode);
            head.put("action", "1");
            head.put("chanel", "0");
            head.put("userAccountID", USER_ACCOUNT_ID);
            head.put("authorizationID", "11111111"); // 业务查询授权号
            request.put("head", head);

            Map body = new HashMap<String, String>();
            body.put("orderID", orderID);
            String bodyJson = JsonUtils.obj2Json(body);
            logger.info("body source:" + bodyJson);
            request.put("body", encryptFlag ? EncryptUtils.encryptWithAES(bodyJson, this.userAccountKey) : body);
            String temp = JsonUtils.obj2Json(request);
            String hashSource = temp.substring(1, temp.length() - 1);
            logger.info("hashSource:" + hashSource);
            request.put("hashValue", HashUtils.hashWithSHA256(hashSource));
            String urlStr = urlPrefix + "/" + urlSuffix;
            logger.info(urlStr);
            PostMethod postMethod = new PostMethod(urlStr);
            String requestStr = JsonUtils.obj2Json(request);
            logger.info("request:" + requestStr);

            StringRequestEntity requestEntity = new StringRequestEntity(requestStr, "application/json", UTF_8);
            postMethod.getParams().setContentCharset(UTF_8);
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);
            logger.info("response code:" + postMethod.getStatusCode());
            InputStream inputStream = postMethod.getResponseBodyAsStream();
            String responseStr = IOUtils.toString(inputStream, "UTF-8");
            postMethod.releaseConnection();

            logger.info("response:" + responseStr);
            Map response = JsonUtils.json2Obj(responseStr, Map.class);
            if ("00000".equals(((Map) response.get("head")).get("code"))) {
                responseBody = encryptFlag ? JsonUtils.json2Obj(
                        EncryptUtils.decryptWithAES((String) response.get("body"), this.userAccountKey), Map.class)
                        : (Map) (response.get("body"));
                logger.info("response body:" + responseBody);
            } else {
                logger.info("查询失败");
                break;
            }
            logger.info("+++++++++++++++++++++++++++++++++");
            logger.info(System.currentTimeMillis() - start);
        }
        return responseBody;
    }
}
