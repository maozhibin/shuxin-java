package com.baoquan.shuxin.service.impl.product.api;

import javax.inject.Inject;

import org.junit.Test;

import com.baoquan.shuxin.TestBase;
import com.baoquan.shuxin.context.AppContext;
import com.baoquan.shuxin.context.ContextInfo;
import com.baoquan.shuxin.third.service.spi.ShengDaService;

/**
 * Desc:
 * Created by yongj on 7/11/2017,
 */
public class ShengDaServiceImplTest extends TestBase {

    @Inject
    private ShengDaService shengDaService;

    @Test
    public void mobile_time_apply() throws Exception {
        ContextInfo contextInfo = new ContextInfo();
        contextInfo.setUserId(1L);
        contextInfo.setClassName("shengda");
        contextInfo.setMethodName("mobile_time_apply");
        AppContext.set(contextInfo);
        System.out.println(shengDaService.mobile_time_apply("18659809803"));
    }

}