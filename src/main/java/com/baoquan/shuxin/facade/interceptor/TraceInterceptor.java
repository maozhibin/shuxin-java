package com.baoquan.shuxin.facade.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Desc:
 * Created by yongj on 7/6/2017,
 */
public class TraceInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(TraceInterceptor.class);

    private final static ThreadLocal<Long> handleStartTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
            handleStartTime.set(System.currentTimeMillis());
            MDC.put("traceId", UUID.randomUUID().toString());
            logger.info("handle request:{}", request.getRequestURI());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
            logger.info("handle request:{} spends time:{}ms", request.getRequestURI(),
                    System.currentTimeMillis() - handleStartTime.get());
        }
        MDC.clear();
    }
}
