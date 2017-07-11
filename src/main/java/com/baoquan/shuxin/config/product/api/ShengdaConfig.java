package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("ShengdaConfig")
public class ShengdaConfig {

    @Value("${shengda.url}")
    private String shengdaUrl;

    @Value("${shengda.merchantNo}")
    private String shengdaMerchantNo;

    @Value("${shengda.signType}")
    private String shengdaSignType;

    @Value("${shengda.md5Key}")
    private String shengdaMd5Key;

    @Value("${shengda.rsaKey}")
    private String shengdaRsaKey;

    @Value("${shengda.charset}")
    private String shengdaCharset;

    public String getShengdaUrl() {
        return shengdaUrl;
    }

    public String getShengdaMerchantNo() {
        return shengdaMerchantNo;
    }

    public String getShengdaSignType() {
        return shengdaSignType;
    }

    public String getShengdaKey() {
        return shengdaMd5Key;
    }

    public String getShengdaRsaKey() {
        return shengdaRsaKey;
    }

    public String getShengdaCharset() {
        return shengdaCharset;
    }
}
