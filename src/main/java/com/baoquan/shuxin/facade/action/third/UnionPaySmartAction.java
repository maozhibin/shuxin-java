package com.baoquan.shuxin.facade.action.third;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.third.service.spi.UnionPaySmartService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/union_pay_smart")
@Api(value = "union-pay-smart-api", description = "union-pay-smart-API", position = 0)
public class UnionPaySmartAction {

    @Inject
    private UnionPaySmartService unionPaySmartServiceImpl;

//	@Inject
//	private RedisService<String> stringRedisService;

    @ResponseBody
    @RequestMapping("/info_executed")
    @ApiOperation(value = "被执行人查询", httpMethod = "POST", response = JsonBean.class, notes = "被执行人查询")
    public JsonBean info_executed(@ApiParam(name = "entityName", value = "主体民称", required = false)
    @RequestParam(value = "entityName", required = false) String entityName,
            @ApiParam(name = "entityId", value = "主体代码", required = false)
            @RequestParam(value = "entityId", required = false) String entityId) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_executed(entityName, entityId);
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
    @RequestMapping("/info_judgement")
    @ApiOperation(value = "裁判文书检索", httpMethod = "POST", response = JsonBean.class, notes = "裁判文书检索")
    public JsonBean info_judgement(@ApiParam(name = "entityName", value = "主体名称", required = true)
    @RequestParam(value = "entityName", required = false) String entityName,
            @ApiParam(name = "type", value = "匹配类型,0:模糊匹配;1:精确匹配.可选,默认模糊匹配", required = false)
            @RequestParam(value = "type", required = false) String type) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_judgement(entityName, type);
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
    @RequestMapping("/info_judgement_detail")
    @ApiOperation(value = "裁判文书详情", httpMethod = "POST", response = JsonBean.class, notes = "裁判文书详情")
    public JsonBean info_judgement_detail(
            @ApiParam(name = "id", value = "公告 id", required = true) @RequestParam(value = "id", required = true)
                    String id) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_judgement_detail(id);
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
    @RequestMapping("/info_court")
    @ApiOperation(value = "法院公告检索", httpMethod = "POST", response = JsonBean.class, notes = "法院公告检索")
    public JsonBean info_court(@ApiParam(name = "entityName", value = "主体名称", required = true)
    @RequestParam(value = "entityName", required = false) String entityName,
            @ApiParam(name = "type", value = "匹配类型,0:模糊匹配;1:精确匹配.可选,默认模糊匹配", required = false)
            @RequestParam(value = "type", required = false) String type) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_court(entityName, type);
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
    @RequestMapping("/info_court_detail")
    @ApiOperation(value = "法院公告详情", httpMethod = "POST", response = JsonBean.class, notes = "法院公告详情")
    public JsonBean info_court_detail(
            @ApiParam(name = "id", value = "公告 id", required = true) @RequestParam(value = "id", required = true)
                    String id) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_court_detail(id);
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
    @RequestMapping("/info_dishonesty")
    @ApiOperation(value = "失信被执行人查询", httpMethod = "POST", response = JsonBean.class, notes = "失信被执行人查询")
    public JsonBean info_dishonesty(@ApiParam(name = "entityName", value = "主体民称", required = false)
    @RequestParam(value = "entityName", required = false) String entityName,
            @ApiParam(name = "entityId", value = "主体代码", required = false)
            @RequestParam(value = "entityId", required = false) String entityId) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_dishonesty(entityName, entityId);
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
    @RequestMapping("/info_personal_invest")
    @ApiOperation(value = "个人工商法信息查询", httpMethod = "POST", response = JsonBean.class, notes = "个人工商法信息查询")
    public JsonBean info_personal_invest(
            @ApiParam(name = "cid", value = "身份证号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = unionPaySmartServiceImpl.info_personal_invest(cid);
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
