package com.baoquan.shuxin.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:
 * Created by justinxu on 2016/11/10,
 */
public class ConfigUtil {
    private final static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    private static PropertiesConfiguration config;

    static {
        config = new PropertiesConfiguration();
        config.setEncoding("utf-8");
        try {
            config.load("conf/config.properties");
        } catch (ConfigurationException e) {
            logger.error("load conf file error", e);
        }
    }

    public static String get(String key, String defaultValue) {
        if (config.containsKey(key)) return config.getString(key);
        return defaultValue;
    }

    public static Integer get(String key, Integer defaultValue) {
        if (config.containsKey(key)) return Integer.parseInt(config.getString(key));
        return defaultValue;
    }

    public static Long get(String key, Long defaultValue) {
        if (config.containsKey(key)) return Long.parseLong(config.getString(key));
        return defaultValue;
    }

    public static Boolean get(String key, Boolean defaultValue) {
        if (config.containsKey(key)) {
            return "true".equalsIgnoreCase(config.getString(key));
        }
        return defaultValue;
    }

}
