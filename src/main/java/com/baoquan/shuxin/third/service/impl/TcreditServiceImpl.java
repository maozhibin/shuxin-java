package com.baoquan.shuxin.third.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;

import com.baoquan.shuxin.config.product.api.TcreditConfig;
import com.baoquan.shuxin.third.service.spi.TcreditService;
import com.baoquan.shuxin.third.util.tcredit.JsoupUtil;
import com.baoquan.shuxin.third.util.tcredit.ParamUtil;

/**
 * Created by Administrator on 2017/5/4.
 */
@Named
public class TcreditServiceImpl implements TcreditService {
    private static Logger logger = Logger.getLogger(TcreditServiceImpl.class);

    @Inject
    private TcreditConfig tcreditConfig;

    private String appId = "b1f9b056-fa12-4217-946b-29105e0d1d7a";

    private String tokenId = "afa60ff4-35ba-4de0-a2a1-1f800dd201ea";

    @PostConstruct
    public void init() {
        this.appId = tcreditConfig.getAppId();
        this.tokenId = tcreditConfig.getTokenId();
    }

    public String getPersonInfo(String idCard, String name) {
        String url = "http://api.tcredit.com/identity/getPersonInfo";

        Map<String, String> param = new HashMap<String, String>();
        param.put("name", name);
        param.put("idcard", idCard);

        String sign = ParamUtil.getTokenKey(url, tokenId, param);
        logger.info(sign);
        param.put("tokenKey", sign);
        param.put("appId", appId);

        try {
            Response content = JsoupUtil.getContent(url, param, null, Connection.Method.POST);
            return content.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDegreeInfo(String idCard, String name) {
        String url = "http://api.tcredit.com/identity/getDegreeInfo";

        Map<String, String> param = new HashMap<String, String>();
        param.put("name", name);
        param.put("idcard", idCard);

        String sign = ParamUtil.getTokenKey(url, tokenId, param);
        logger.info(sign);
        param.put("tokenKey", sign);
        param.put("appId", appId);

        return simpleOutput(url, param);
    }

    public String getCertificate(String idCard, String name) {
        String url = "http://api.tcredit.com/identity/getCertificate";

        Map<String, String> param = new HashMap<String, String>();
        param.put("name", name);
        param.put("idcard", idCard);

        String sign = ParamUtil.getTokenKey(url, tokenId, param);
        logger.info(sign);
        param.put("tokenKey", sign);
        param.put("appId", appId);

        return simpleOutput(url, param);
    }

    public String verifyRealNameFlag(String mobile) {
        String url = "http://api.tcredit.com/mobile/verifyRealNameFlag";

        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", mobile);

        String sign = ParamUtil.getTokenKey(url, tokenId, param);
        logger.info(sign);
        param.put("tokenKey", sign);
        param.put("appId", appId);

        return simpleOutput(url, param);
    }

    private static String simpleOutput(String url, Map<String, String> param) {
        try {
            Response content = JsoupUtil.getContent(url, param, null, Connection.Method.POST);
            logger.info(content);
            logger.info(content.body());
            return content.body();
        } catch (Exception e) {
            logger.info("an error happened : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
