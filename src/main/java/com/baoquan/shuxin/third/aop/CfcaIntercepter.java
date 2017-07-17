package com.baoquan.shuxin.third.aop;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.config.GlobalConfig;
import com.baoquan.shuxin.config.product.api.CfcaConfig;
import com.baoquan.shuxin.service.spi.RedisService;
import com.baoquan.shuxin.third.util.cfca.EncryptUtils;
import com.baoquan.shuxin.third.util.cfca.HttpUtils;
import com.baoquan.shuxin.third.util.cfca.SSLProtocolSocketFactory;

/**
 * Created by Administrator on 2017/5/5.
 * Aspect 类似通知
 */
@Aspect
@Component
public class CfcaIntercepter {
    private static Logger logger = Logger.getLogger(CfcaIntercepter.class);

    private final static String REDIS_PREFIX = "dsj_cfca_";

    @Inject
    protected GlobalConfig globalConfig;

    @Inject
    private RedisService<String> stringRedisService;

    @Inject
    private CfcaConfig cfcaConfig;

    @Pointcut("execution(* com.baoquan.shuxin.third.service.impl.CfcaServiceImpl.*(..))")
    private void aspect() {
    }

    /**
     * 检测Appkey是否过期
     */
    @Before("aspect()")
    public void Before() {
        Protocol protocol = new Protocol("https", new SSLProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", protocol);

        String lastKey = stringRedisService.get(REDIS_PREFIX + "last_key");
        logger.info("last key is : " + lastKey);
        if (lastKey == null) {
            logger.error("Get empty last key");

            //todo 暂时添加
            stringRedisService.add(REDIS_PREFIX + "last_key",
                    globalConfig.getCfca_last_key() + "," + String.valueOf(System.currentTimeMillis()));
        } else {
            String arr[] = lastKey.split(",");
            if (arr.length < 2) {
                logger.error("last key split result with error format");
            }

            String userAccountKey = arr[0];
            String expire = arr[1];
            long expireTime = Long.parseLong(expire);
            //过期时间小于当前时间，重新请求AppKey
            if (expireTime <= System.currentTimeMillis()) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("lastKey", userAccountKey); // lastKey第一次申请密钥时可随意输入，第二次申请传入之前申请到的密钥明文
                params.put("lastKeyGenTime", FastDateFormat.getInstance("yyyyMMddHHmmss").format(new Date()));
                params.put("validationTime", "0");
                params.put("keyType", "0");
                try {
                    HttpUtils httpUtils = new HttpUtils(cfcaConfig);
                    Map responseBody = httpUtils.requestNotEncryptSync("CF00000001", "apply-for-key.json", params);
                    if (responseBody != null) {
                        String newKey = (String) ((Map) responseBody.get("result")).get("newKey");
                        String key = EncryptUtils.decryptWithAES(newKey,
                                cfcaConfig.getCfcaHomeKey()); // 替换USER_ACCOUNT_KEY
                        long time = System.currentTimeMillis();
                        Date date = new Date(time);

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        calendar.add(Calendar.DATE, 25);

                        stringRedisService.add(REDIS_PREFIX + "last_key",
                                key + "," + String.valueOf(calendar.getTimeInMillis()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                logger.info("last key didn't expire");
            }
        }
    }
}
