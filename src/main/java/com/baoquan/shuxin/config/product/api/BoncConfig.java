package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("boncConfig")
public class BoncConfig {

    @Value("${bonc.host}")
    private String boncHost;

    @Value("${bonc.port}")
    private int boncPort;

    @Value("${bonc.appKey}")
    private String boncAppKey;

    @Value("${bonc.appSecret}")
    private String boncAppSecret;

    public String getBoncHost() {
        return boncHost;
    }

    public int getBoncPort() {
        return boncPort;
    }

    public String getBoncAppKey() {
        return boncAppKey;
    }

    public String getBoncAppSecret() {
        return boncAppSecret;
    }
}
