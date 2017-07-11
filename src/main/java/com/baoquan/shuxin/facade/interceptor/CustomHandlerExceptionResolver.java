package com.baoquan.shuxin.facade.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    private final static Logger logger = LoggerFactory.getLogger(CustomHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.info("resolve exception:{} {}", ex.getClass(), ex.getMessage());

        logger.error("!!!unresolved exception!!!", ex);
        return null;
    }
}
