package com.baoquan.shuxin.web.controller.superb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.enums.AdminUserMenuPermEnum;
import com.baoquan.shuxin.model.admin.AdminUser;
import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;
import com.baoquan.shuxin.service.spi.admin.AdminMenuService;
import com.baoquan.shuxin.service.spi.admin.AdminUserMenuPermService;
import com.baoquan.shuxin.service.spi.admin.AdminUserService;
import com.baoquan.shuxin.util.JsonResponseMsg;
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

    /**
     * 跳转到添加管理员页面
     */
    @RequestMapping("skip")
    public ModelAndView skip(String id){
        ModelAndView mv = new ModelAndView("admin/super/auth/addOrUpdate");
        if(NumberUtils.isNumber(id)){
            AdminUser adminUser = adminUserService.queryById(NumberUtils.toLong(id));
            mv.addObject(adminUser);
        }
        return mv;
    }

    /**
     * 添加管理员功能
     */
    @RequestMapping("addAdmin")
    @ResponseBody
    public JsonResponseMsg udpateAdmin(String userName,String password,String copyPassword){
        JsonResponseMsg result = new JsonResponseMsg();
       
        if(StringUtils.isEmpty(userName)){
            return  result.fill(JsonResponseMsg.CODE_FAIL,"请你输入用户名");
        }
        if(!adminUserService.queryByUsername(userName)){
            return  result.fill(JsonResponseMsg.CODE_FAIL,"你输入的用户名已经存在了");
        }
        if(StringUtils.isEmpty(password)){
            return  result.fill(JsonResponseMsg.CODE_FAIL,"请你输入密码");
        }
        if(password.length() < 8){
        	 return  result.fill(JsonResponseMsg.CODE_FAIL,"请输入管理员密码，字符数在8-20位!");
        }
        if(StringUtils.isEmpty(copyPassword)){
            return  result.fill(JsonResponseMsg.CODE_FAIL,"请你确认密码");
        }
        adminUserService.addAdminUserInfo(userName,password,copyPassword);
        
        return  result.fill(JsonResponseMsg.CODE_SUCCESS,"添加成功");
    }
}
