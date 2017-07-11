package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("TcreditConfig")
public class TcreditConfig {
    @Value("${tcredit.appId}")
    private String appId;

    @Value("${tcredit.tokenId}")
    private String tokenId;

    public String getAppId() {
        return appId;
    }

    public String getTokenId() {
        return tokenId;
    }
}
