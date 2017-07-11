package com.baoquan.shuxin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("globalConfig")
public class GlobalConfig {

    @Value("${redis.prefix}")
    private String redis_prefix;

    @Value("${cfca.last_key}")
    private String cfca_last_key;


    public String getRedis_prefix() {
        return redis_prefix;
    }

    public void setRedis_prefix(String redis_prefix) {
        this.redis_prefix = redis_prefix;
    }

    public String getCfca_last_key() {
        return cfca_last_key;
    }

    public void setCfca_last_key(String cfca_last_key) {
        this.cfca_last_key = cfca_last_key;
    }
}
