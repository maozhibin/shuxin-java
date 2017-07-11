package com.baoquan.shuxin.service.spi.product.api;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface HuntianService {

    public String antiFraud(String scene, String phone, String ip, String imei, String imsi,
            String idcard, String name, String bankcard, String qq,
            String wechat, String email, String tel, String address,
            String url, String context);

    public String identityVerify(String name, String identityNo, String validityBegin, String validityEnd);

    public String statistics();
}
