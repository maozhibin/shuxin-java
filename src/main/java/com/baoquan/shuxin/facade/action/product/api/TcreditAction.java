package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.TcreditService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/tcredit")
@Api(value = "tcredit-api", description = "tcredit-API", position = 0)
public class TcreditAction {

    @Inject
    private TcreditService tcreditServiceImpl;

//	@Inject
//	private RedisService<String> stringRedisService;

    @ResponseBody
    @RequestMapping("/get_degree_info")
    @ApiOperation(value = "个人学历信息查询", httpMethod = "POST", response = JsonBean.class, notes = "个人学历信息查询")
    public JsonBean get_degree_info(@ApiParam(name = "idCard", value = "身份证号码", required = true)
    @RequestParam(value = "idCard", required = true) String idCard,
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam(value = "name", required = true)
                    String name) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = tcreditServiceImpl.getDegreeInfo(idCard, name);
            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

    @ResponseBody
    @RequestMapping("/get_certificate")
    @ApiOperation(value = "查询个人所获的职业资格证书信息", httpMethod = "POST", response = JsonBean.class, notes = "查询个人所获的职业资格证书信息")
    public JsonBean get_certificate(@ApiParam(name = "idCard", value = "身份证号码", required = true)
    @RequestParam(value = "idCard", required = true) String idCard,
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam(value = "name", required = true)
                    String name) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = tcreditServiceImpl.getCertificate(idCard, name);
            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

    @ResponseBody
    @RequestMapping("/verify_real_name_flag")
    @ApiOperation(value = "查询个人所获的职业资格证书信息", httpMethod = "POST", response = JsonBean.class, notes = "查询个人所获的职业资格证书信息")
    public JsonBean verify_real_name_flag(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = tcreditServiceImpl.verifyRealNameFlag(mobile);
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