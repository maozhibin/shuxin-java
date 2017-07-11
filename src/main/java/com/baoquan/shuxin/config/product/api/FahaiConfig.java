package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("fahaiConfig")
public class FahaiConfig {

    @Value("${fahai.host}")
    private String fahaiHost;

    @Value("${fahai.scheme}")
    private String fahaiScheme;

    @Value("${fahai.authCode}")
    private String fahaiAuthCode;

    public String getFahaiHost() {
        return fahaiHost;
    }

    public String getFahaiScheme() {
        return fahaiScheme;
    }

    public String getFahaiAuthCode() {
        return fahaiAuthCode;
    }
}
