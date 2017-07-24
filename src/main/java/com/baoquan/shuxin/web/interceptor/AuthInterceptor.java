package com.baoquan.shuxin.web.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.baoquan.shuxin.web.vo.auth.MenuVO;
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
            Long userId = (Long) request.getSession(true).getAttribute("ADMIN_USER_ID");
            if (userId == null) {
                response.sendRedirect("/admin/loginPage");
                return false;
            }
            //对直接访问的路径鉴权
            String uri = request.getRequestURI();
            if (!hasPerm(userId, uri)) {
                return false;
            }

            //对请求来源页面间接鉴权
            //Referer: http://localhost:8080//admin/super/auth/list
            String referer = request.getHeader("Referer");
            if (StringUtils.isNotBlank(referer)) {
                String basePath = StringUtils.removeEnd(request.getRequestURL().toString(), request.getRequestURI());
                referer = StringUtils.removeStartIgnoreCase(referer, basePath);
                referer = StringUtils.substringBefore(referer, "?");
                if (!hasPerm(userId, referer)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean hasPerm(Long userId, String uri) {
        Matcher matcher = uriPattern.matcher(uri);
        if (matcher.find()) {
            uri = matcher.group();
        }
        /*
        不在配置中的uri
        1.找最匹配上级，找到则以之为准
        2.默认放过
         */
        AdminMenu menu = adminMenuService.queryByUri(uri);
        if (menu == null) {
            int length = 0;
            List<AdminMenu> menus = adminMenuService.queryAllEffective();
            for (AdminMenu adminMenu : menus) {
                if (StringUtils.startsWithIgnoreCase(uri, adminMenu.getUri())) {
                    if (StringUtils.length(adminMenu.getUri()) > length) {
                        menu = adminMenu;
                        length = StringUtils.length(adminMenu.getUri());
                    }
                }
            }
        }
        if (menu != null) {
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
            if (modelAndView == null) {
                return;
            }
            Long userId = (Long) request.getSession(true).getAttribute("ADMIN_USER_ID");
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
