package com.baoquan.shuxin.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc:
 * Created by yongj on 7/13/2017,
 */
@Controller
public class AdminIndexController {

    @RequestMapping({"/", "/admin"})
    public String index() {
        return "admin/index";
    }
}
