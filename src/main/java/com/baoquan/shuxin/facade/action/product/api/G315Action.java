package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.G315Service;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/5/2.
 */
@Controller
@RequestMapping("/g315")
@Api(value = "g315-api", description = "中胜信用", position = 0)
public class G315Action {
    @Inject
    private G315Service g315ServiceImpl;

    @ResponseBody
    @RequestMapping("/new_identity")
    @ApiOperation(value = "手机号实名+证件", httpMethod = "POST", response = JsonBean.class, notes = "手机号实名+证件")
    public JsonBean fullQuery(@ApiParam(name = "identityCard", value = "身份证号", required = true)
    @RequestParam(value = "identityCard", required = true) String identityCard,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = g315ServiceImpl.newIdentity(identityCard, mobile);

            System.out.println(str);
            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }
}
