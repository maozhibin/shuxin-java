package com.baoquan.shuxin.facade.action.third;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.third.service.spi.ShengDaService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/shengda")
@Api(value = "sheng-da-api", description = "盛大API", position = 0)
public class ShengDaAction {

    @Inject
    private ShengDaService shengDaServiceImpl;

//	@Inject
//	private RedisService<String> stringRedisService;

    @ResponseBody
    @RequestMapping("/idcard_two_apply")
    @ApiOperation(value = "身份证二要素验证", httpMethod = "POST", response = JsonBean.class, notes = "身份证二要素验证")
    public JsonBean idcard_two_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.idcard_two_apply(identityNo, trueName);

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
    @RequestMapping("/three_items_apply")
    @ApiOperation(value = "银行卡三要素", httpMethod = "POST", response = JsonBean.class, notes = "银行卡三要素")
    public JsonBean three_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "cardNo", value = "卡号", required = true) @RequestParam(value = "cardNo", required = true)
                    String cardNo,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.three_items_apply(identityNo, trueName, cardNo, mobile);

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
    @RequestMapping("/mobile_items_apply")
    @ApiOperation(value = "手机号实名", httpMethod = "POST", response = JsonBean.class, notes = "手机号实名")
    public JsonBean mobile_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.mobile_items_apply(identityNo, trueName, mobile);

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
    @RequestMapping("/four_items_apply")
    @ApiOperation(value = "银行卡四要素", httpMethod = "POST", response = JsonBean.class, notes = "银行卡四要素")
    public JsonBean four_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "cardNo", value = "银行卡号", required = true) @RequestParam(value = "cardNo", required = true)
                    String cardNo) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.four_items_apply(identityNo, trueName, cardNo, mobile);

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
    @RequestMapping("/idcard_badinfo_apply")
    @ApiOperation(value = "不良信息", httpMethod = "POST", response = JsonBean.class, notes = "不良信息")
    public JsonBean idcard_badinfo_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.idcard_badinfo_apply(identityNo, trueName);

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
    @RequestMapping("/education_items_apply")
    @ApiOperation(value = "学历", httpMethod = "POST", response = JsonBean.class, notes = "学历")
    public JsonBean education_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.education_items_apply(identityNo, trueName);

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
    @RequestMapping("/photo_comp_apply")
    @ApiOperation(value = "高清人像比对", httpMethod = "POST", response = JsonBean.class, notes = "高清人像比对")
    public JsonBean education_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "photo", value = "图片base64编码", required = true)
            @RequestParam(value = "photo", required = true) String photo) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.photo_comp_apply(identityNo, trueName, photo);

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
    @RequestMapping("/mobile_status_apply")
    @ApiOperation(value = "手机在网状态", httpMethod = "POST", response = JsonBean.class, notes = "手机在网状态")
    public JsonBean mobile_status_apply(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.mobile_status_apply(mobile);

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
    @RequestMapping("/mobile_time_apply")
    @ApiOperation(value = "手机在网状态", httpMethod = "POST", response = JsonBean.class, notes = "手机在网状态")
    public JsonBean mobile_time_apply(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.mobile_time_apply(mobile);

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
    @RequestMapping("/mutidebit_items_apply")
    @ApiOperation(value = "多头负债", httpMethod = "POST", response = JsonBean.class, notes = "多头负债")
    public JsonBean mutidebit_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.mutidebit_items_apply(identityNo, trueName, mobile);

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
    @RequestMapping("/black_items_apply")
    @ApiOperation(value = "信贷黑名单", httpMethod = "POST", response = JsonBean.class, notes = "信贷黑名单")
    public JsonBean black_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.black_items_apply(identityNo, trueName, mobile);

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
    @RequestMapping("/interview_items_apply")
    @ApiOperation(value = "职业简历", httpMethod = "POST", response = JsonBean.class, notes = "职业简历")
    public JsonBean interview_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.interview_items_apply(identityNo, trueName, mobile);

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
    @RequestMapping("/personflight_items_apply")
    @ApiOperation(value = "航空出行", httpMethod = "POST", response = JsonBean.class, notes = "航空出行")
    public JsonBean personflight_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "month", value = "最近乘机月份范围", required = true)
            @RequestParam(value = "month", required = true) String month) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.personflight_items_apply(identityNo, trueName, month);

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
    @RequestMapping("/residence_items_apply")
    @ApiOperation(value = "户籍查询", httpMethod = "POST", response = JsonBean.class, notes = "户籍查询")
    public JsonBean residence_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.residence_items_apply(identityNo, trueName);

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
    @RequestMapping("/banktrade_items_apply")
    @ApiOperation(value = "银行交易报告", httpMethod = "POST", response = JsonBean.class, notes = "银行交易报告")
    public JsonBean banktrade_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "cardNo", value = "银行卡号", required = true) @RequestParam(value = "cardNo", required = true)
                    String cardNo) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.banktrade_items_apply(identityNo, trueName, cardNo, mobile);

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
    @RequestMapping("/personinvest_items_apply")
    @ApiOperation(value = "个人投资", httpMethod = "POST", response = JsonBean.class, notes = "个人投资")
    public JsonBean personinvest_items_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.personinvest_items_apply(identityNo, trueName);

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
    @RequestMapping("/badinfo_detail_apply")
    @ApiOperation(value = "黑名单详情", httpMethod = "POST", response = JsonBean.class, notes = "黑名单详情")
    public JsonBean badinfo_detail_apply(@ApiParam(name = "identityNo", value = "身份证号", required = true)
    @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "trueName", value = "姓名", required = true)
            @RequestParam(value = "trueName", required = true) String trueName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.badinfo_detail_apply(identityNo, trueName);

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
    @RequestMapping("/person_face_apply")
    @ApiOperation(value = "面部识别", httpMethod = "POST", response = JsonBean.class, notes = "面部识别")
    public JsonBean person_face_apply(
            @ApiParam(name = "photo", value = "照片", required = true) @RequestParam(value = "photo", required = true)
                    String photo,
            @ApiParam(name = "image", value = "图像", required = true) @RequestParam(value = "image", required = true)
                    String image) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.person_face_apply(photo, image);

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
    @RequestMapping("/drive_five_items_apply")
    @ApiOperation(value = "驾驶证", httpMethod = "POST", response = JsonBean.class, notes = "驾驶证")
    public JsonBean drive_five_items_apply(@ApiParam(name = "trueName", value = "照片", required = true)
    @RequestParam(value = "trueName", required = true) String trueName,
            @ApiParam(name = "identityNo", value = "身份证号", required = true)
            @RequestParam(value = "identityNo", required = true) String identityNo,
            @ApiParam(name = "archiveNo", value = "驾驶证号", required = true)
            @RequestParam(value = "archiveNo", required = true) String archiveNo,
            @ApiParam(name = "firstRecDate", value = "获取驾照日期", required = true)
            @RequestParam(value = "firstRecDate", required = true) String firstRecDate,
            @ApiParam(name = "permitModel", value = "驾照类型", required = true)
            @RequestParam(value = "permitModel", required = true) String permitModel) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = shengDaServiceImpl.drive_five_items_apply(identityNo, trueName, archiveNo, firstRecDate,
                    permitModel);

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
