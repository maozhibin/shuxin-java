package com.baoquan.shuxin.third.service.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.config.product.api.BoncConfig;
import com.baoquan.shuxin.third.service.spi.BoncService;
import com.baoquan.shuxin.third.util.MD5Util;
import com.baoquan.shuxin.third.util.fahai.FaHaiHttpClient;

/**
 * Created by Administrator on 2017/5/18.
 */
@Named
public class BoncServiceImpl implements BoncService {
    private static Logger logger = Logger.getLogger(BoncServiceImpl.class);

    @Inject
    private BoncConfig boncConfig;

    public String groupNameFlag(String mobile) {
        String method = "groupNameFlag";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String talkTimeLengthLabel(String mobile, String month) {
        String method = "talkTimeLengthLabel";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            bizParams.put("month", month);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String callCountTop5Label(String mobile, String month) {
        String method = "callCountTop5Label";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            bizParams.put("month", month);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String roamCountIn3MonthsLabel(String mobile, String month) {
        String method = "roamCountIn3MonthsLabel";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            bizParams.put("month", month);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String talkTimeLengthDawnPtgScore(String mobile, String month) {
        String method = "talkTimeLengthDawnPtgScore";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            bizParams.put("month", month);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String abnormalContactScore(String mobile, String month) {
        String method = "abnormalContactScore";
        try {
            Map<String, String> bizParams = new HashMap<String, String>();
            bizParams.put("mobile", mobile);
            bizParams.put("month", month);
            return getContent(method, bizParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getContent(String method, Map<String, String> bizParams) throws Exception {
        String req = JSON.toJSONString(bizParams);
        String token = getToken(method, req);
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost(boncConfig.getBoncHost())
                .setPort(boncConfig.getBoncPort())
                .setPath("/test/v4/queryinfo.jsonp")
                .setParameter("appKey", boncConfig.getBoncAppKey())
                .setParameter("token", token)
                .setParameter("method", method)
                .setParameter("bizParams", req);

        URI uri = uriBuilder.build();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
        return faHaiHttpClient.Get(httpClient, uri);
    }

    private String getToken(String method, String bizParams) {
        return MD5Util.MD5(
                boncConfig.getBoncAppKey() + boncConfig.getBoncAppSecret() + method + bizParams).toLowerCase();
    }
}
