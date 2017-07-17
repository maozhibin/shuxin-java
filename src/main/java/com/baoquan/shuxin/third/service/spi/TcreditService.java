package com.baoquan.shuxin.third.service.spi;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface TcreditService {
    public String getDegreeInfo(String idCard, String name);

    public String getCertificate(String idCard, String name);

    public String verifyRealNameFlag(String mobile);
}
