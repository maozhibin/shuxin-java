package com.baoquan.shuxin.third.aop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.config.GlobalConfig;
import com.baoquan.shuxin.config.product.api.G315Config;
import com.baoquan.shuxin.third.service.impl.G315ServiceImpl;
import com.baoquan.shuxin.service.spi.RedisService;
import com.baoquan.shuxin.third.util.MD5Util;
import com.baoquan.shuxin.third.util.cfca.SSLProtocolSocketFactory;

/**
 * Created by Administrator on 2017/5/5.
 * Aspect 类似通知
 */
@Aspect
@Component
public class G315Intercepter {
    private static Logger logger = Logger.getLogger(G315Intercepter.class);

    @Inject
    private G315Config g315Config;

    private String ACCOUNT = "";

    private String PASSWORD = "";

    private String URL = "";

    private final static String REDIS_PREFIX = G315ServiceImpl.getRedisPrefix();

    @PostConstruct
    public void init() {
        this.ACCOUNT = g315Config.getG315Account();
        this.PASSWORD = g315Config.getG315Password();
        this.URL = g315Config.getG315Url();
    }

    @Inject
    protected GlobalConfig globalConfig;

    @Inject
    private RedisService<String> stringRedisService;

    @Pointcut("execution(* com.baoquan.shuxin.third.service.impl.G315ServiceImpl.*(..))")
    private void aspect() {
    }

    /**
     * 检测Appkey是否过期
     */
    @Before("aspect()")
    public void Before() {
        Protocol protocol = new Protocol("https", new SSLProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", protocol);

        String loginResponse = stringRedisService.get(REDIS_PREFIX + "login_response");
        logger.info("login response is : " + loginResponse);
        if (loginResponse == null) {
            logger.error("Get empty login response");

            //todo 暂时添加
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                String uri = URL;
                String md5str = MD5Util.MD5(PASSWORD).substring(8, 24);
                uri += "?msg=" + ACCOUNT + md5str + "&token=&action=login";
                logger.info(uri);
                HttpGet httpGet = new HttpGet(uri);
                CloseableHttpResponse response = httpClient.execute(httpGet);

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
                loginResponse = data.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringRedisService.add(REDIS_PREFIX + "login_response", loginResponse, 30 * 60);
        }
    }
}
