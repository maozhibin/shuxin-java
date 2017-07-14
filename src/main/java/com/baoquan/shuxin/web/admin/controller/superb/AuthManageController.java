package com.baoquan.shuxin.web.admin.controller.superb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
@Controller
@RequestMapping("/super/auth")
public class AuthManageController {
    private final static Logger logger = LoggerFactory.getLogger(AuthManageController.class);

    @RequestMapping("/list")
    public Object list() {
        return "admin/super/auth/list";
    }
}
