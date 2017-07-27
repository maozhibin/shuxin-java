package com.baoquan.shuxin.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.model.admin.AdminUser;
import com.baoquan.shuxin.service.spi.admin.AdminUserService;
import com.baoquan.shuxin.util.IPUtils;

/**
 * Desc:
 * Created by yongj on 7/13/2017,
 */
@Controller
public class AdminController {

    @RequestMapping({"/", "/admin"})
    public String index() {
        return "redirect:/admin/overview/platform";
    }

    @RequestMapping({"/loginPage"})
    public String loginPage() {
        return "admin/login";
    }

    @Inject
    private AdminUserService adminUserService;

    @RequestMapping({"/login"})
    @ResponseBody
    public Object login(String account, String password, HttpServletRequest request) {
        JsonBean jsonBean = new JsonBean();
        AdminUser adminUser = adminUserService.queryByUserPass(account, password);
        if (adminUser == null) {
            jsonBean.setCode(-1);
            jsonBean.setMessage("登陆失败,请重试!");
            jsonBean.setData("请重试!");
            return jsonBean;
        }
        String ip = IPUtils.getIp(request);
        Long timestamp = System.currentTimeMillis();
        adminUserService.refreshLoginInfoById(adminUser.getId(), ip, timestamp);
        request.getSession(true).setAttribute("ADMIN_USER_ID", adminUser.getId());
        request.getSession(true).setMaxInactiveInterval(1800);
        jsonBean.setCode(0);
        jsonBean.setMessage("登陆成功");
        return jsonBean;
    }

    @RequestMapping({"/logout"})
    public String logout(HttpServletRequest request) {
        request.getSession(true).removeAttribute("ADMIN_USER_ID");
        return "admin/login";
    }

    @RequestMapping({"/password"})
    public String password() {
        return "admin/password";
    }

    @RequestMapping({"/password/modify"})
    @ResponseBody
    public Object passwordModify(@RequestParam("old_pass") String oldPass, @RequestParam("new_pass") String newPss,
            HttpServletRequest request) {
        JsonBean jsonBean = new JsonBean();
        Long userId = (Long) request.getSession(true).getAttribute("ADMIN_USER_ID");
        int rows = adminUserService.modifyPassword(userId, oldPass, newPss);
        if (rows > 0) {
            jsonBean.setCode(0);
            jsonBean.setMessage("修改成功!");
        } else {
            jsonBean.setCode(-1);
            jsonBean.setMessage("用户名或密码不正确,修改失败!");
        }
        return jsonBean;
    }
}
