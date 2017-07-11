package com.baoquan.shuxin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * Created by yongj on 7/11/2017,
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "test/greeting";
    }

    @RequestMapping("/plain")
    @ResponseBody
    public Object plain() {
        return "Hello world!";
    }
}
