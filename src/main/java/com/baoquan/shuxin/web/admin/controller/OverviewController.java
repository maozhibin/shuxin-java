package com.baoquan.shuxin.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc:
 * Created by yongj on 7/15/2017,
 */
@Controller
@RequestMapping("/overview")
public class OverviewController {

    @RequestMapping("/platform")
    public Object platform() {
        return "admin/overview/platform";
    }

    @RequestMapping("/organization")
    public Object organization() {
        return "admin/overview/organization";
    }

    @RequestMapping("/product")
    public Object product() {
        return "admin/overview/product";
    }

}
