package com.baoquan.shuxin.facade.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.context.AppContext;
import com.baoquan.shuxin.context.ContextInfo;
import com.baoquan.shuxin.facade.auth.Auth;
import com.baoquan.shuxin.facade.auth.AuthUtil;

/**
 * Desc:
 * Created by yongj on 7/6/2017,
 */
public class AuthInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
            String authStr = request.getHeader("AUTH");
            authStr = "{\"userId\":\"1\"}";
            if (StringUtils.isBlank(authStr)) {
                logger.warn("AUTH is blank!");
                return false;
            }
            Auth auth = AuthUtil.dec(authStr);
            if (auth == null) {
                logger.error("Invalid AUTH!");
                return false;
            }
            AuthUtil.hold(auth);
            ContextInfo contextInfo = new ContextInfo();
            contextInfo.setUserId(auth.getUserId());

            //fixme? host..*/class/method?query
            String[] pathParts = StringUtils.split(request.getRequestURI(), '/');
            if (pathParts.length < 2) {
                logger.error("RequestURI[{}] is to short, ensure it has class and method in the path?");
                return false;
            }
            String className = pathParts[pathParts.length - 2];
            String methodName = pathParts[pathParts.length - 1];
            contextInfo.setClassName(className);
            contextInfo.setMethodName(methodName);
            AppContext.set(contextInfo);
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
            AuthUtil.clear();
            AppContext.remove();
        }
    }
}
