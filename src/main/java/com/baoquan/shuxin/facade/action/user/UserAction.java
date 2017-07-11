package com.baoquan.shuxin.facade.action.user;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.RedisService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/user")
@Api(value = "user-api", description = "用户管理", position = 0)
public class UserAction {

    @Inject
    private RedisService<String> stringRedisService;

    @ResponseBody
    @RequestMapping("/login")
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = JsonBean.class, notes = "用户登录")
    public JsonBean login(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required =
                    true) String mobile,
            @ApiParam(name = "password", value = "密码", required = true) @RequestParam(value = "password", required =
                    true) String password) {
        JsonBean jsonBean = new JsonBean();

        try {

            stringRedisService.add("mobile", mobile);

            jsonBean.setCode(0);
            jsonBean.setData(new HashMap<String, Object>());

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

}
