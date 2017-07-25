package com.baoquan.shuxin.web.controller.superb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.enums.AdminUserMenuPermEnum;
import com.baoquan.shuxin.model.admin.AdminUser;
import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;
import com.baoquan.shuxin.service.spi.admin.AdminMenuService;
import com.baoquan.shuxin.service.spi.admin.AdminUserMenuPermService;
import com.baoquan.shuxin.service.spi.admin.AdminUserService;
import com.baoquan.shuxin.web.vo.auth.AdminUserMenuPermVO;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
@Controller
@RequestMapping("/super/auth")
public class AuthManageController {
    private final static Logger logger = LoggerFactory.getLogger(AuthManageController.class);

    @Inject
    private AdminUserService adminUserService;
    @Inject
    private AdminUserMenuPermService adminUserMenuPermService;
    @Inject
    private AdminMenuService adminMenuService;

    @RequestMapping("/list")
    public Object list(String keywords, Integer pageNo, Integer pageSize) {
        ModelAndView mav = new ModelAndView("admin/super/auth/list");
        if (pageNo == null || pageNo < 1) pageNo = 1;
        if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
        keywords = StringUtils.trimToNull(keywords);

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        Long userCount = adminUserService.countUserByName(keywords);
        page.setTotalRecordCount(userCount);

        if (userCount > (pageNo - 1) * pageSize) {
            List<AdminUser> userList = adminUserService.listUserByName(keywords, (pageNo - 1) * pageSize, pageSize);
            List<AdminUserMenuPermVO> userMenuPermVOList = new ArrayList<>(userList.size());
            for (AdminUser user : userList) {
                userMenuPermVOList.add(buildAdminUserMenuPermVO(user));
            }
            Map<Long, AdminUserMenuPermVO> userMap = new HashMap<>(userMenuPermVOList.size());
            for (AdminUserMenuPermVO vo : userMenuPermVOList) {
                userMap.put(vo.getUserId(), vo);
            }
            List<AdminUserMenuPerm> menuPermList = adminUserMenuPermService.listEffectiveByUser(userMap.keySet());
            fillUserMenuPermVO(menuPermList, userMap);

            page.setResult(userMenuPermVOList);
        }
        mav.addObject("menus", adminMenuService.queryEffectiveMenuTree());
        mav.addObject("perms", AdminUserMenuPermEnum.getPermMap());
        mav.addObject("page", page);
        mav.addObject("keywords", keywords);
        return mav;
    }


    private AdminUserMenuPermVO buildAdminUserMenuPermVO(AdminUser user) {
        AdminUserMenuPermVO vo = new AdminUserMenuPermVO();
        vo.setUserId(user.getId());
        vo.setUsername(user.getUsername());
        if (user.getLastTime() != null) {
            vo.setLastLoginTime(new Date(user.getLastTime()));
        }
        return vo;
    }

    private void fillUserMenuPermVO(List<AdminUserMenuPerm> menuPermList, Map<Long, AdminUserMenuPermVO> userMap) {
        for (AdminUserMenuPerm userMenuPerm : menuPermList) {
            AdminUserMenuPermVO vo = userMap.get(userMenuPerm.getUserId());
            Map<Long, Integer> menuPerm = vo.getMenuPerm();
            if (menuPerm == null) {
                vo.setMenuPerm(new HashMap<Long, Integer>());
                menuPerm = vo.getMenuPerm();
            }
            menuPerm.put(userMenuPerm.getMenuId(), userMenuPerm.getPerm());
        }
    }

    @RequestMapping("/edit")
    public Object edit(Long userId) {
        ModelAndView mav = new ModelAndView("admin/super/auth/edit");
        AdminUser user = adminUserService.queryById(userId);

        AdminUserMenuPermVO userMenuPerm = buildAdminUserMenuPermVO(user);
        List<AdminUserMenuPermVO> userMenuPermVOList = new ArrayList<>(1);
        userMenuPermVOList.add(userMenuPerm);
        Map<Long, AdminUserMenuPermVO> userMap = new HashMap<>(userMenuPermVOList.size());
        for (AdminUserMenuPermVO vo : userMenuPermVOList) {
            userMap.put(vo.getUserId(), vo);
        }
        List<AdminUserMenuPerm> menuPermList = adminUserMenuPermService.listEffectiveByUser(userMap.keySet());
        fillUserMenuPermVO(menuPermList, userMap);
        if (userMenuPerm.getMenuPerm() == null) {
            userMenuPerm.setMenuPerm(new HashMap<Long, Integer>());
        }

        mav.addObject("user", userMenuPerm);
        mav.addObject("menus", adminMenuService.queryEffectiveMenuTree());
        mav.addObject("perms", AdminUserMenuPermEnum.getPermMap());
        return mav;
    }

    @RequestMapping("/update")
    public Object update(Long userId, @RequestParam(value = "menuId", required = false) Long[] menuIds) {
        adminUserMenuPermService.resetUserMenuPerm(userId, menuIds);
        return "redirect:edit?userId=" + userId;
    }
}