package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("huntianConfig")
public class HuntianConfig {

    @Value("${huntian.host}")
    private String huntianHost;

    @Value("${huntian.scheme}")
    private String huntianScheme;

    @Value("${huntian.appSecret}")
    private String huntianAppSecret;

    @Value("${huntian.path}")
    private String huntianPath;

    @Value("${huntian.uuid}")
    private String huntianUuid;

    public String getHuntianHost() {
        return huntianHost;
    }

    public String getHuntianScheme() {
        return huntianScheme;
    }

    public String getHuntianAppSecret() {
        return huntianAppSecret;
    }

    public String getHuntianPath() {
        return huntianPath;
    }

    public String getHuntianUuid() {
        return huntianUuid;
    }
}
