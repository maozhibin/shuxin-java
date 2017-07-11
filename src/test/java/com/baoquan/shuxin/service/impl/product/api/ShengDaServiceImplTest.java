package com.baoquan.shuxin.service.impl.product.api;

import javax.inject.Inject;

import org.junit.Test;

import com.baoquan.shuxin.TestBase;
import com.baoquan.shuxin.service.spi.product.api.ShengDaService;

/**
 * Desc:
 * Created by yongj on 7/11/2017,
 */
public class ShengDaServiceImplTest extends TestBase {

    @Inject
    private ShengDaService shengDaService;

    @Test
    public void mobile_time_apply() throws Exception {
        System.out.println(shengDaService.mobile_time_apply("18659809803"));
    }

}