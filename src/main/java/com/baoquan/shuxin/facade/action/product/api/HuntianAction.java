package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.HuntianService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/5/2.
 */
@Controller
@RequestMapping("/huntian")
@Api(value = "hun-tian-api", description = "浑天api", position = 0)
public class HuntianAction {

    //Logger logger = Logger.getLogger(HuntianAction.class);

    @Inject
    private HuntianService huntianServiceImpl;

    @ResponseBody
    @RequestMapping("/fraud")
    @ApiOperation(value = "反欺诈查询", httpMethod = "POST", response = JsonBean.class, notes = "反欺诈查询")
    public JsonBean fraud(
            @ApiParam(name = "scene", value = "场景ID", required = true) @RequestParam(value = "scene", required = true)
                    String scene,
            @ApiParam(name = "phone", value = "手机号码", required = true) @RequestParam(value = "phone", required = true)
                    String phone,
            @ApiParam(name = "ip", value = "ip", required = false) @RequestParam(value = "ip", required = false)
                    String ip,
            @ApiParam(name = "imei", value = "imei", required = false) @RequestParam(value = "imei", required = false)
                    String imei,
            @ApiParam(name = "imsi", value = "imsi", required = false) @RequestParam(value = "imsi", required = false)
                    String imsi, @ApiParam(name = "idcard", value = "身份证号", required = false)
    @RequestParam(value = "idcard", required = false) String idcard,
            @ApiParam(name = "name", value = "姓名", required = false) @RequestParam(value = "name", required = false)
                    String name, @ApiParam(name = "bankcard", value = "银行卡号", required = false)
    @RequestParam(value = "bankcard", required = false) String bankcard,
            @ApiParam(name = "qq", value = "qq", required = false) @RequestParam(value = "qq", required = false)
                    String qq, @ApiParam(name = "wechat", value = "微信号", required = false)
    @RequestParam(value = "wechat", required = false) String wechat,
            @ApiParam(name = "email", value = "邮箱", required = false) @RequestParam(value = "email", required = false)
                    String email,
            @ApiParam(name = "tel", value = "固定电话", required = false) @RequestParam(value = "tel", required = false)
                    String tel, @ApiParam(name = "address", value = "所在地址", required = false)
    @RequestParam(value = "address", required = false) String address,
            @ApiParam(name = "url", value = "需要检测的页面地址", required = false)
            @RequestParam(value = "url", required = false) String url,
            @ApiParam(name = "context", value = "上下文信息", required = false)
            @RequestParam(value = "context", required = false) String context) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = huntianServiceImpl.antiFraud(scene, phone, ip, imei, imsi, idcard, name, bankcard, qq, wechat,
                    email, tel, address, url, context);

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

    @ResponseBody
    @RequestMapping("/identity_verify")
    @ApiOperation(value = "实名验证", httpMethod = "POST", response = JsonBean.class, notes = "实名验证")
    public JsonBean identity_verify(
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam(value = "name", required = true)
                    String name,
            @ApiParam(name = "id_no", value = "身份证号", required = true) @RequestParam(value = "id_no", required = true)
                    String id_no, @ApiParam(name = "validity_begin", value = "有效期起始日期", required = false)
    @RequestParam(value = "validity_begin", required = false) String validity_begin,
            @ApiParam(name = "validity_end", value = "有效期结束日期", required = false)
            @RequestParam(value = "validity_end", required = false) String validity_end) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = huntianServiceImpl.identityVerify(name, id_no, validity_begin, validity_end);

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
