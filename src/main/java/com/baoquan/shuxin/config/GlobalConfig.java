package com.baoquan.shuxin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("globalConfig")
public class GlobalConfig {

    @Value("${redis.prefix}")
    private String redis_prefix;

    public String getRedis_prefix() {
        return redis_prefix;
    }

    public void setRedis_prefix(String redis_prefix) {
        this.redis_prefix = redis_prefix;
    }

}
