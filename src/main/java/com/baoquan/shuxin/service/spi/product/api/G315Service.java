package com.baoquan.shuxin.service.spi.product.api;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface G315Service {
    public String newIdentity(String identityCard, String mobile);

    public String newTimeOnline(String mobile);

    public String newStatusOnline(String mobile);

    public String newName(String mobile);

    public String newIdentityName(String identityNo, String mobile, String name);

    public String newConsume(String mobile, String rangeCode);

    public String newBlack(String key, String keyType);

    public String newSocialShb(String key);

    public String newSocialShp(String key);

    public String newSaiccpn(String key);

    public String newRptsp(String key, String name);

    public String newSaicpsn(String key);
}
