package com.baoquan.shuxin.service.impl.product.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.service.spi.RedisService;
import com.baoquan.shuxin.service.spi.product.api.G315Service;

/**
 * Created by Administrator on 2017/5/18.
 */
@Named
public class G315ServiceImpl implements G315Service {
    private static Logger logger = Logger.getLogger(G315ServiceImpl.class);

    @Inject
    private RedisService<String> stringRedisService;

    private final static String REDIS_PREFIX = "dsj_g315_";

    public static String getRedisPrefix() {
        return REDIS_PREFIX;
    }

    private JSONObject getLoginResponse() {
        String loginResponseStr = stringRedisService.get(REDIS_PREFIX + "login_response");
        return JSON.parseObject(loginResponseStr);
    }

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public String newIdentity(String identityCard, String mobile) {
        Map<String, String> mobidRequestMain = new HashMap<>();

        mobidRequestMain.put("mobile", mobile);
        mobidRequestMain.put("idType", "0101");
        mobidRequestMain.put("idNo", identityCard);
        mobidRequestMain.put("cid", "");

        Map<String, Map> request = new HashMap<String, Map>();
        request.put(mobile, mobidRequestMain);
        String req = JSON.toJSONString(request);

        logger.info("token is :" + getLoginResponse().getString("msg"));
        logger.info("req is :" + req);

        List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
        formParams.add(new BasicNameValuePair("action", "mobid"));
        formParams.add(new BasicNameValuePair("token", getLoginResponse().getString("msg")));
        formParams.add(new BasicNameValuePair("mid", "110"));
        formParams.add(new BasicNameValuePair("msg", req));
        formParams.add(new BasicNameValuePair("f", "2"));
        try {
            return getContent(getLoginResponse().getString("callbackUrl"), formParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String newTimeOnline(String mobile) {
        return null;
    }

    public String newStatusOnline(String mobile) {
        return null;
    }

    public String newName(String mobile) {
        return null;
    }

    public String newIdentityName(String identityNo, String mobile, String name) {
        return null;
    }

    public String newConsume(String mobile, String rangeCode) {
        return null;
    }

    public String newBlack(String key, String keyType) {
        return null;
    }

    public String newSocialShb(String key) {
        return null;
    }

    public String newSocialShp(String key) {
        return null;
    }

    public String newSaiccpn(String key) {
        return null;
    }

    public String newRptsp(String key, String name) {
        return null;
    }

    public String newSaicpsn(String key) {
        return null;
    }

    private static String getContent(String uri, List<BasicNameValuePair> params) throws Exception {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);

        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() != 200) {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        HttpEntity httpEntity = response.getEntity();
        if (httpEntity == null) {
            throw new ClientProtocolException("Response contains no content");
        }

        ContentType contentType = ContentType.getOrDefault(httpEntity);
        Charset charset = contentType.getCharset();
        Reader reader = new InputStreamReader(httpEntity.getContent(), charset);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder data = new StringBuilder();
        for (String line = null; ((line = bufferedReader.readLine()) != null); data.append(line))
            ;
        bufferedReader.close();
        return data.toString();
    }
}
