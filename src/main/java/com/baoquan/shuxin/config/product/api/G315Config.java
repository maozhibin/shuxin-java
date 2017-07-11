package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("g315Config")
public class G315Config {

    @Value("${g315.url}")
    private String g315Url;

    @Value("${g315.account}")
    private String g315Account;

    @Value("${g315.password}")
    private String g315Password;

    public String getG315Url() {
        return g315Url;
    }

    public String getG315Account() {
        return g315Account;
    }

    public String getG315Password() {
        return g315Password;
    }
}
