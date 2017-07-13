package com.baoquan.shuxin.service.aop.product;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * Created by yongj on 7/12/2017,
 */
@Aspect
@Component
public class ThirdCallLoggingInterceptor {

    @Pointcut("execution(* com.baoquan.shuxin.service.spi.product..*.*(..))")
    private void aspect() {
    }

    @After("aspect()")
    public void after() {
        
    }
}
