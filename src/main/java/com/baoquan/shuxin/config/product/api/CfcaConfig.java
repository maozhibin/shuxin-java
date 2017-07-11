package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("cfcaConfig")
public class CfcaConfig {

    @Value("${cfca.homeKey}")
    private String cfcaHomeKey;

    @Value("${cfca.urlPrefix}")
    private String cfcaUrlPrefix;

    @Value("${cfca.userAccountId}")
    private String cfcaUserAccountId;

    @Value("${cfca.userAccountKey}")
    private String cfcaUserAccountKey;

    @Value("${cfca.defaultSleepTime}")
    private int cfcaDefaultSleepTime;

    @Value("${cfca.asyncGetResultTryCount}")
    private int cfcaAsyncGetResultTryCount;

    public String getCfcaHomeKey() {
        return cfcaHomeKey;
    }

    public String getCfcaUrlPrefix() {
        return cfcaUrlPrefix;
    }

    public String getCfcaUserAccountId() {
        return cfcaUserAccountId;
    }

    public String getCfcaUserAccountKey() {
        return cfcaUserAccountKey;
    }

    public int getCfcaDefaultSleepTime() {
        return cfcaDefaultSleepTime;
    }

    public int getCfcaAsyncGetResultTryCount() {
        return cfcaAsyncGetResultTryCount;
    }
}
