package com.baoquan.shuxin.web.admin.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.enums.DualStatusEnum;
import com.baoquan.shuxin.model.admin.AdminMenu;
import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;
import com.baoquan.shuxin.service.spi.admin.AdminMenuService;
import com.baoquan.shuxin.service.spi.admin.AdminUserMenuPermService;
import com.baoquan.shuxin.web.vo.admin.auth.MenuVO;
import com.google.common.collect.Lists;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
public class AuthInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Inject
    private AdminUserMenuPermService adminUserMenuPermService;
    @Inject
    private AdminMenuService adminMenuService;

    private Pattern uriPattern = Pattern.compile("(/\\w+)+");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
            Long userId = (Long) request.getSession(true).getAttribute("userId");
            if (userId == null) {
                response.sendRedirect("/admin/loginPage");
                return false;
            }
            String uri = request.getRequestURI();
            //int index = StringUtils.indexOf(uri, "/admin");
            //if (index > 0) {
            //    uri = StringUtils.substring(uri, index);
            //}
            Matcher matcher = uriPattern.matcher(uri);
            if (matcher.find()) {
                uri = matcher.group();
            }
            AdminMenu menu = adminMenuService.queryByUri(uri);
            if (menu == null) {
                return true;
            }
            AdminUserMenuPerm userMenuPerm = adminUserMenuPermService.queryByUserMenuStatus(userId, menu.getId(),
                    DualStatusEnum.EFFECTIVE.getCode());
            if (userMenuPerm == null || userMenuPerm.getPerm() == DualStatusEnum.INEFFECTIVE.getCode()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
            Long userId = (Long) request.getSession(true).getAttribute("userId");
            if (userId == null) {
                return;
            }
            List<AdminUserMenuPerm> menuPermList = adminUserMenuPermService.listEffectiveByUser(
                    Lists.newArrayList(userId));
            List<AdminMenu> menuList = new ArrayList<>();
            for (AdminUserMenuPerm menuPerm : menuPermList) {
                if (menuPerm.getPerm() > 0) {
                    menuList.add(adminMenuService.queryById(menuPerm.getMenuId()));
                }
            }
            Map<Long, MenuVO> userMenu = adminMenuService.buildMenuVOMap(menuList);
            modelAndView.addObject("userMenu", userMenu);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (HandlerMethod.class.isInstance(handler)) {
        }
    }
}
