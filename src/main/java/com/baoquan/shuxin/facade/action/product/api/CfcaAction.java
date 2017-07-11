package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.CfcaService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/cfca")
@Api(value = "cfca-api", description = "cfca-API", position = 0)
public class CfcaAction {

    @Inject
    private CfcaService cfcaServiceImpl;

    @ResponseBody
    @RequestMapping("/check_company_name")
    @ApiOperation(value = "商户名称", httpMethod = "POST", response = JsonBean.class, notes = "商户名称")
    public JsonBean check_company_name(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = false)
            @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkCompanyName(companyMID, companyName, registrationNumber, personName);

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
    @RequestMapping("/check_company_type")
    @ApiOperation(value = "商户类型", httpMethod = "POST", response = JsonBean.class, notes = "商户类型")
    public JsonBean check_company_type(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = false)
            @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkCompanyType(companyMID, companyName, registrationNumber, personName);

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
    @RequestMapping("/check_POS_balance_max")
    @ApiOperation(value = "每月最大交易金额", httpMethod = "POST", response = JsonBean.class, notes = "每月最大交易金额")
    public JsonBean check_POS_balance_max(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = true)
            @RequestParam(value = "companyName", required = true) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPOSBalanceMax(companyMID, companyName, registrationNumber, personName);

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
    @RequestMapping("/search_POS_card_acceptance")
    @ApiOperation(value = "每月笔单价枚举", httpMethod = "POST", response = JsonBean.class, notes = "每月笔单价枚举")
    public JsonBean search_POS_card_acceptance(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = true)
            @RequestParam(value = "companyName", required = true) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPOSCardAcceptance(companyMID, companyName, registrationNumber,
                    personName);

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
    @RequestMapping("/search_POS_annulus_growth")
    @ApiOperation(value = "每月交易金额环比增长枚举", httpMethod = "POST", response = JsonBean.class, notes = "每月交易金额环比增长枚举")
    public JsonBean search_POS_annulus_growth(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = true)
            @RequestParam(value = "companyName", required = true) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPOSAnnulusGrowth(companyMID, companyName, registrationNumber,
                    personName);

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
    @RequestMapping("/search_POS_MoM_increase")
    @ApiOperation(value = "每月交易额同比增长均值枚举", httpMethod = "POST", response = JsonBean.class, notes = "每月交易额同比增长均值枚举")
    public JsonBean search_POS_MoM_increase(@ApiParam(name = "companyMID", value = "真实商户编号", required = true)
    @RequestParam(value = "companyMID", required = true) String companyMID,
            @ApiParam(name = "companyName", value = "企业名称", required = true)
            @RequestParam(value = "companyName", required = true) String companyName,
            @ApiParam(name = "registrationNumber", value = "原工商注册号", required = false)
            @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @ApiParam(name = "personName", value = "姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPOSMoMIncrease(companyMID, companyName, registrationNumber, personName);

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
    @RequestMapping("/card_consuming_frequent_city")
    @ApiOperation(value = "近12月消费次数最多的城市接口", httpMethod = "POST", response = JsonBean.class, notes = "近12月消费次数最多的城市接口")
    public JsonBean card_consuming_frequent_city(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cardConsumingFrequentCity(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/repayment_ability")
    @ApiOperation(value = "还贷能力指标", httpMethod = "POST", response = JsonBean.class, notes = "还贷能力指标")
    public JsonBean repayment_ability(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.repaymentAbility(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/card_level")
    @ApiOperation(value = "卡等级", httpMethod = "POST", response = JsonBean.class, notes = "卡等级")
    public JsonBean card_level(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cardLevel(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/last_payment_area")
    @ApiOperation(value = "最近一笔交易城市", httpMethod = "POST", response = JsonBean.class, notes = "最近一笔交易城市")
    public JsonBean last_payment_area(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.lastPaymentArea(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/last_payment_amount")
    @ApiOperation(value = "最近一笔交易金额", httpMethod = "POST", response = JsonBean.class, notes = "最近一笔交易金额")
    public JsonBean last_payment_amount(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.lastPaymentAmount(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/year_payment_sum")
    @ApiOperation(value = "近12月消费类交易总金额", httpMethod = "POST", response = JsonBean.class, notes = "近12月消费类交易总金额")
    public JsonBean year_payment_sum(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.yearPaymentSum(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/consumption_location_info")
    @ApiOperation(value = "工作时间、非工作时间消费区域", httpMethod = "POST", response = JsonBean.class, notes = "工作时间、非工作时间消费区域")
    public JsonBean consumption_location_info(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.consumptionLocationInfo(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/oversea_payment_sum")
    @ApiOperation(value = "境外交易金额", httpMethod = "POST", response = JsonBean.class, notes = "境外交易金额")
    public JsonBean oversea_payment_sum(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.overseaPaymentSum(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/card_charge_off_sum")
    @ApiOperation(value = "近6月银行卡出账总金额", httpMethod = "POST", response = JsonBean.class, notes = "近6月银行卡出账总金额")
    public JsonBean card_charge_off_sum(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cardChargeOffSum(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/enter_in_account_sum")
    @ApiOperation(value = "近6月银行卡入账总金额", httpMethod = "POST", response = JsonBean.class, notes = "近6月银行卡入账总金额")
    public JsonBean enter_in_account_sum(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.enterInAccountSum(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/charge_off_MCC")
    @ApiOperation(value = "MCC金额分布", httpMethod = "POST", response = JsonBean.class, notes = "MCC金额分布")
    public JsonBean charge_off_MCC(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.chargeOffMCC(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/house_payment")
    @ApiOperation(value = "是否够房", httpMethod = "POST", response = JsonBean.class, notes = "是否够房")
    public JsonBean house_payment(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.housePayment(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/vehicle_payment")
    @ApiOperation(value = "是否够车", httpMethod = "POST", response = JsonBean.class, notes = "是否够车")
    public JsonBean vehicle_payment(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "email", value = "手机号码", required = false) @RequestParam(value = "email", required = false)
                    String email, @ApiParam(name = "address", value = "地址", required = false)
    @RequestParam(value = "address", required = false) String address) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.vehiclePayment(personName, cardNumber, identityType, identityNumber,
                    cellPhoneNumber, email, address);

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
    @RequestMapping("/cellphone_account_balance")
    @ApiOperation(value = "当前话费余额", httpMethod = "POST", response = JsonBean.class, notes = "当前话费余额")
    public JsonBean cellphone_account_balance(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cellphoneAccountBalance(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/cellphone_online_months")
    @ApiOperation(value = "当前入网时长( 月) ", httpMethod = "POST", response = JsonBean.class, notes = "当前入网时长( 月) ")
    public JsonBean cellphone_online_months(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cellphoneOnlineMonths(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_device_number")
    @ApiOperation(value = "号码和设备信息查验 ", httpMethod = "POST", response = JsonBean.class, notes = "号码和设备信息查验")
    public JsonBean cellphone_online_months(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "deviceNumber", value = "设备号码", required = true)
            @RequestParam(value = "deviceNumber", required = true) String deviceNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkDeviceNumber(personName, identityType, identityNumber, cellPhoneNumber,
                    deviceNumber);

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
    @RequestMapping("/check_personal_cellphone_numbers")
    @ApiOperation(value = "当前自然人绑定的手机号查询", httpMethod = "POST", response = JsonBean.class, notes = "当前自然人绑定的手机号查询")
    public JsonBean check_personal_cellphone_numbers(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalCellphoneNumbers(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_roaming_times")
    @ApiOperation(value = "最近3个月漫游通话次数查询", httpMethod = "POST", response = JsonBean.class, notes = "最近3个月漫游通话次数查询")
    public JsonBean check_roaming_times(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkRoamingTimes(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/check_data_usage")
    @ApiOperation(value = "最近3个月流量均值查询", httpMethod = "POST", response = JsonBean.class, notes = "最近3个月流量均值查询")
    public JsonBean check_data_usage(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkDataUsage(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/check_2year_number_changes")
    @ApiOperation(value = "2年内换号次数（不换手机）查询", httpMethod = "POST", response = JsonBean.class, notes = "2年内换号次数（不换手机）查询")
    public JsonBean check_2year_number_changes(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.check2YearNumberChanges(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_3year_phone_changes")
    @ApiOperation(value = "3年内换手机次数（不换号码）查询",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "3  " + "年内换手机次数（不换号码）查询")
    public JsonBean check_3year_phone_changes(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.check3YearPhoneChanges(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_phone_brand")
    @ApiOperation(value = "当前手机品牌查询", httpMethod = "POST", response = JsonBean.class, notes = "当前手机品牌查询")
    public JsonBean check_phone_brand(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPhoneBrand(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/check_blacklist_id")
    @ApiOperation(value = "查验案底记录", httpMethod = "POST", response = JsonBean.class, notes = "查验案底记录")
    public JsonBean check_blacklist_id(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistId(personName, identityType, identityNumber);

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
    @RequestMapping("/check_blacklist_account")
    @ApiOperation(value = "帐卡号涉案查验", httpMethod = "POST", response = JsonBean.class, notes = "帐卡号涉案查验")
    public JsonBean check_blacklist_account(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistAccount(personName, identityType, identityNumber, cardNumber);

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
    @RequestMapping("/check_personal_id")
    @ApiOperation(value = "身份证信息验证", httpMethod = "POST", response = JsonBean.class, notes = "身份证信息验证")
    public JsonBean check_personal_id(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalId(personName, identityType, identityNumber);

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
    @RequestMapping("/check_personal_account")
    @ApiOperation(value = "银行卡四要素认证", httpMethod = "POST", response = JsonBean.class, notes = "银行卡四要素认证")
    public JsonBean check_personal_account(@ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
    @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "bankId", value = "银行名称", required = false)
            @RequestParam(value = "bankId", required = false) String bankId,
            @ApiParam(name = "cardType", value = "卡类型", required = true)
            @RequestParam(value = "cardType", required = true) String cardType,
            @ApiParam(name = "validDate", value = "信用卡有效期", required = false)
            @RequestParam(value = "validDate", required = false) String validDate,
            @ApiParam(name = "cvn2", value = "信用卡背面末 3 位数", required = false)
            @RequestParam(value = "cvn2", required = false) String cvn2,
            @ApiParam(name = "personName", value = "姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalAccount(cardNumber, bankId, cardType, validDate, cvn2, personName,
                    identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/cellphone_account_overdue")
    @ApiOperation(value = "当前欠费余额", httpMethod = "POST", response = JsonBean.class, notes = "当前欠费余额")
    public JsonBean cellphone_account_overdue(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cellphoneAccountOverdue(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/cellphone_account_reward_points")
    @ApiOperation(value = "当前可兑换积分", httpMethod = "POST", response = JsonBean.class, notes = "当前可兑换积分")
    public JsonBean cellphone_account_reward_points(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cellphoneAccountRewardPoints(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_sim")
    @ApiOperation(value = "当前可兑换积分", httpMethod = "POST", response = JsonBean.class, notes = "当前可兑换积分")
    public JsonBean check_sim(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "imsi", value = "号码和SIM信息查验", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String imsi) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkSim(personName, identityType, identityNumber, cellPhoneNumber, imsi);

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
    @RequestMapping("/check_1year_number_changes")
    @ApiOperation(value = "1年内换号次数（不换手机）查询", httpMethod = "POST", response = JsonBean.class, notes = "1年内换号次数（不换手机）查询")
    public JsonBean check_1year_number_changes(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.check1YearNumberChanges(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_1year_phone_changes")
    @ApiOperation(value = "1年内换手机次数（不换号码）查询",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "1年内换手机次数（不换号码）查询")
    public JsonBean check_1year_phone_changes(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.check1YearPhoneChanges(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_highest_quality_education")
    @ApiOperation(value = "最高学历查验", httpMethod = "POST", response = JsonBean.class, notes = "最高学历查验")
    public JsonBean check_highest_quality_education(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "highestEducation", value = "最高学历", required = true)
            @RequestParam(value = "highestEducation", required = true) String highestEducation,
            @ApiParam(name = "graduateInstitution", value = "毕业院校", required = true)
            @RequestParam(value = "graduateInstitution", required = true) String graduateInstitution,
            @ApiParam(name = "graduateYear", value = "入学时间", required = true)
            @RequestParam(value = "graduateYear", required = true) String graduateYear) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkHighQualityEducation(personName, identityType, identityNumber,
                    cellPhoneNumber, highestEducation, graduateInstitution, graduateYear);

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
    @RequestMapping("/education_background_info")
    @ApiOperation(value = "学历查寻", httpMethod = "POST", response = JsonBean.class, notes = "学历查寻")
    public JsonBean education_background_info(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.educationBackgroundInfo(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_phone_number_location")
    @ApiOperation(value = "手机号码归属地查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号码归属地查询")
    public JsonBean check_phone_number_location(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPhoneNumberLocation(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_deposit_bank")
    @ApiOperation(value = "按卡号查询所属银行（开户行）查询",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "按卡号查询所属银行（开户行）查询")
    public JsonBean check_deposit_bank(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkDepositBank(personName, identityType, identityNumber, cardNumber);

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
    @RequestMapping("/check_personal_id_T2")
    @ApiOperation(value = "个人身份信息（带照片）验证", httpMethod = "POST", response = JsonBean.class, notes = "个人身份信息（带照片）验证")
    public JsonBean check_personal_id_T2(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "photo", value = "照片，取base64", required = true)
            @RequestParam(value = "photo", required = true) String photo) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalIdT2(personName, identityType, identityNumber, cardNumber, photo);

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
    @RequestMapping("/check_blacklist_id_T2")
    @ApiOperation(value = "银联不良持卡人识别", httpMethod = "POST", response = JsonBean.class, notes = "银联不良持卡人识别")
    public JsonBean check_blacklist_id_T2(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistIdT2(personName, identityType, identityNumber);

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
    @RequestMapping("/check_blacklist_account_T2")
    @ApiOperation(value = "不良银联卡识别", httpMethod = "POST", response = JsonBean.class, notes = "不良银联卡识别")
    public JsonBean check_blacklist_account_T2(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistAccountT2(personName, identityType, identityNumber, cardNumber);

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
    @RequestMapping("/check_blacklist_cellphone_T2")
    @ApiOperation(value = "银联风险电话识别", httpMethod = "POST", response = JsonBean.class, notes = "银联风险电话识别")
    public JsonBean check_blacklist_cellphone_T2(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistCellphoneT2(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/search_personal_judgment_document")
    @ApiOperation(value = "个人 法院裁判文书数据查询", httpMethod = "POST", response = JsonBean.class, notes = "个人 法院裁判文书数据查询")
    public JsonBean search_personal_judgment_document(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPersonalJudgmentDocument(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/search_personal_execution_document")
    @ApiOperation(value = "查询个人执行文书 查询", httpMethod = "POST", response = JsonBean.class, notes = "查询个人执行文书 查询")
    public JsonBean search_personal_execution_document(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPersonalExecutionDocument(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_personal_discredit_info")
    @ApiOperation(value = "个人失信公告", httpMethod = "POST", response = JsonBean.class, notes = "个人失信公告")
    public JsonBean check_personal_discredit_info(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalDiscreditInfo(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/search_personal_P2P_blacklist_info")
    @ApiOperation(value = "个人网贷黑名单详情", httpMethod = "POST", response = JsonBean.class, notes = "个人网贷黑名单详情")
    public JsonBean search_personal_P2P_blacklist_info(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchPersonalP2PBlacklistInfo(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/personal_flight_statistic")
    @ApiOperation(value = "航空出行报告", httpMethod = "POST", response = JsonBean.class, notes = "航空出行报告")
    public JsonBean personal_flight_statistic(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.personalFlightStatistic(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/company_registration_and_supervision_report")
    @ApiOperation(value = "工商信息报告", httpMethod = "POST", response = JsonBean.class, notes = "工商信息报告")
    public JsonBean company_registration_and_supervision_report(
            @ApiParam(name = "companyName", value = "企业名称", required = false)
            @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.companyRegistrationAndSupervisionReport(companyName, uniformCreditCode);

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
    @RequestMapping("/search_lawperson_company_report")
    @ApiOperation(value = "按法人查询工商信息", httpMethod = "POST", response = JsonBean.class, notes = "按法人查询工商信息")
    public JsonBean search_lawperson_company_report(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.searchLawpersonCompanyReport(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/education_info_with_photo")
    @ApiOperation(value = "学历查寻接口带照片", httpMethod = "POST", response = JsonBean.class, notes = "学历查寻接口带照片")
    public JsonBean education_info_with_photo(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.educationInfoWithPhoto(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/check_personal_account_info_3")
    @ApiOperation(value = "银行卡三要素信息验证", httpMethod = "POST", response = JsonBean.class, notes = "银行卡三要素信息验证")
    public JsonBean check_personal_account_info_3(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = false)
            @RequestParam(value = "cellPhoneNumber", required = false) String cellPhoneNumber,
            @ApiParam(name = "cardType", value = "帐卡类型", required = true)
            @RequestParam(value = "cardType", required = true) String cardType,
            @ApiParam(name = "valiDate", value = "信用卡有效期", required = false)
            @RequestParam(value = "valiDate", required = false) String valiDate,
            @ApiParam(name = "cvn2", value = "信用卡背面末3位数字", required = false)
            @RequestParam(value = "cvn2", required = false) String cvn2,
            @ApiParam(name = "cardNumber", value = "账号号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalAccountInfo(personName, identityType, identityNumber,
                    cellPhoneNumber, cardType, valiDate, cvn2, cardNumber);

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
    @RequestMapping("/company_registration_info")
    @ApiOperation(value = "工商执照信息查询", httpMethod = "POST", response = JsonBean.class, notes = "工商执照信息查询")
    public JsonBean company_registration_info(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.companyRegistrationInfo(companyName, uniformCreditCode);

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
    @RequestMapping("/check_person_plateNum")
    @ApiOperation(value = "车号牌- 车牌类型- 所有人查验(三要素)",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "车号牌- " + "车牌类型- 所有人查验(三要素)")
    public JsonBean check_person_plateNum(@ApiParam(name = "plateNumber", value = "号牌号码", required = true)
    @RequestParam(value = "plateNumber", required = true) String plateNumber,
            @ApiParam(name = "vehicleType", value = "号牌种类", required = true)
            @RequestParam(value = "vehicleType", required = true) String vehicleType,
            @ApiParam(name = "personName", value = "所有人姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonPlateNum(plateNumber, vehicleType, personName, cellPhoneNumber);

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
    @RequestMapping("/check_person_engineNum_plateNum")
    @ApiOperation(value = "车辆信息查验( 号牌- 所有人- 发动机号三要素)",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "车辆信息查验( 号牌- 所有人- 发动机号三要素)")
    public JsonBean check_person_engineNum_plateNum(@ApiParam(name = "plateNumber", value = "号牌号码", required = true)
    @RequestParam(value = "plateNumber", required = true) String plateNumber,
            @ApiParam(name = "vehicleType", value = "号牌种类", required = true)
            @RequestParam(value = "vehicleType", required = true) String vehicleType,
            @ApiParam(name = "engineNumber", value = "发动机号码", required = true)
            @RequestParam(value = "engineNumber", required = true) String engineNumber,
            @ApiParam(name = "personName", value = "所有人姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonEngineNumPlateNum(plateNumber, vehicleType, engineNumber,
                    personName, cellPhoneNumber);

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
    @RequestMapping("/check_legal_driving_vehicle")
    @ApiOperation(value = "准架车型查验", httpMethod = "POST", response = JsonBean.class, notes = "准架车型查验")
    public JsonBean check_legal_driving_vehicle(@ApiParam(name = "drivingLicence", value = "驾驶证号码", required = true)
    @RequestParam(value = "drivingLicence", required = true) String drivingLicence,
            @ApiParam(name = "vehicleType", value = "号牌种类", required = true)
            @RequestParam(value = "vehicleType", required = true) String vehicleType,
            @ApiParam(name = "personName", value = "所有人姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkLegalDrivingVehicle(drivingLicence, vehicleType, personName,
                    cellPhoneNumber);

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
    @RequestMapping("/check_registered_driving_vehicle")
    @ApiOperation(value = "车牌号登记日期查验", httpMethod = "POST", response = JsonBean.class, notes = "车牌号登记日期查验")
    public JsonBean check_registered_driving_vehicle(@ApiParam(name = "plateNumber", value = "号牌号码", required = true)
    @RequestParam(value = "plateNumber", required = true) String plateNumber,
            @ApiParam(name = "plateType", value = "号牌种类", required = true)
            @RequestParam(value = "plateType", required = true) String plateType,
            @ApiParam(name = "personName", value = "所有人姓名", required = false)
            @RequestParam(value = "personName", required = false) String personName,
            @ApiParam(name = "registrationDate", value = "初次登记日期", required = true)
            @RequestParam(value = "registrationDate", required = true) String registrationDate,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkRegisteredDrivingVehicle(plateNumber, plateType, personName,
                    registrationDate, cellPhoneNumber);

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
    @RequestMapping("/check_registered_driver")
    @ApiOperation(value = "驾驶证登记日期查验", httpMethod = "POST", response = JsonBean.class, notes = "驾驶证登记日期查验")
    public JsonBean check_registered_driver(@ApiParam(name = "drivingLicence", value = "驾驶证号", required = true)
    @RequestParam(value = "drivingLicence", required = true) String drivingLicence,
            @ApiParam(name = "personName", value = "姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "registrationDate", value = "初次登记日期", required = true)
            @RequestParam(value = "registrationDate", required = true) String registrationDate,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkRegisteredDriver(drivingLicence, personName, registrationDate,
                    cellPhoneNumber);

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
    @RequestMapping("/check_registered_driver1")
    @ApiOperation(value = "驾驶证档案编号查验", httpMethod = "POST", response = JsonBean.class, notes = "驾驶证档案编号查验")
    public JsonBean check_registered_driver1(@ApiParam(name = "drivingLicence", value = "驾驶证号", required = true)
    @RequestParam(value = "drivingLicence", required = true) String drivingLicence,
            @ApiParam(name = "personName", value = "姓名", required = true)
            @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "documentID", value = "档案编号", required = true)
            @RequestParam(value = "documentID", required = true) String documentID,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkRegisteredDriver1(drivingLicence, personName, documentID,
                    cellPhoneNumber);

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
    @RequestMapping("/check_personal_identity")
    @ApiOperation(value = "支付类五渠道验证身份信息", httpMethod = "POST", response = JsonBean.class, notes = "支付类五渠道验证身份信息")
    public JsonBean check_personal_identity(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumb", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumb", required = true) String cellPhoneNumb,
            @ApiParam(name = "cardNumber", value = "帐卡号码", required = true)
            @RequestParam(value = "cardNumber", required = true) String cardNumber,
            @ApiParam(name = "vehicleType", value = "准驾车型", required = false)
            @RequestParam(value = "vehicleType", required = false) String vehicleType,
            @ApiParam(name = "highestEducation", value = "最高学历", required = false)
            @RequestParam(value = "highestEducation", required = false) String highestEducation,
            @ApiParam(name = "photo", value = "照片", required = false) @RequestParam(value = "photo", required = false)
                    String photo) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalIdentity(personName, identityType, identityNumber, cellPhoneNumb,
                    cardNumber, vehicleType, highestEducation, photo);

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
    @RequestMapping("/company_judgment_document")
    @ApiOperation(value = "企业法院裁判文书数据查询", httpMethod = "POST", response = JsonBean.class, notes = "企业法院裁判文书数据查询")
    public JsonBean company_judgment_document(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.companyJudgmentDocument(companyName, uniformCreditCode);

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
    @RequestMapping("/company_execution_document")
    @ApiOperation(value = "查询企业执行文书查询", httpMethod = "POST", response = JsonBean.class, notes = "查询企业执行文书查询")
    public JsonBean company_execution_document(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.companyExecutionDocument(companyName, uniformCreditCode);

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
    @RequestMapping("/check_company_discredit_info")
    @ApiOperation(value = "企业失信公告查询", httpMethod = "POST", response = JsonBean.class, notes = "企业失信公告查询")
    public JsonBean check_company_discredit_info(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkCompanyDiscreditInfo(companyName, uniformCreditCode);

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
    @RequestMapping("/company_owing_tax")
    @ApiOperation(value = "企业欠税公告查询", httpMethod = "POST", response = JsonBean.class, notes = "企业欠税公告查询")
    public JsonBean company_owing_tax(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.companyOwingTax(companyName, uniformCreditCode);

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
    @RequestMapping("/abnormal_company_taxpayerId")
    @ApiOperation(value = "企业纳税非正常户查询", httpMethod = "POST", response = JsonBean.class, notes = "企业纳税非正常户查询")
    public JsonBean abnormal_company_taxpayerId(@ApiParam(name = "companyName", value = "企业名称", required = false)
    @RequestParam(value = "companyName", required = false) String companyName,
            @ApiParam(name = "uniformCreditCode", value = "注册号", required = false)
            @RequestParam(value = "uniformCreditCode", required = false) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.abnormalCompanyTaxpayerId(companyName, uniformCreditCode);

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
    @RequestMapping("/cellphone_real_name_registration")
    @ApiOperation(value = "三网运营商手机实名查验(三要素)",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "三网运营商手机实名查验" + "(三要素)")
    public JsonBean cellphone_real_name_registration(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.cellphoneReadNameRegistration(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/census_registration_info")
    @ApiOperation(value = "个人户籍信息查询", httpMethod = "POST", response = JsonBean.class, notes = "个人户籍信息查询")
    public JsonBean census_registration_info(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.censusRegistrationInfo(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/census_registration_photo")
    @ApiOperation(value = "身份证信息查询( 返照片)", httpMethod = "POST", response = JsonBean.class, notes = "身份证信息查询( 返照片)")
    public JsonBean census_registration_photo(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.censusRegistrationPhoto(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/SMS_deliver")
    @ApiOperation(value = "移动、联通、电信三网推送短信信息(单笔)",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "移动、联通、电信三网推送短信信息(单笔)")
    public JsonBean SMS_deliver(@ApiParam(name = "destinationPhoneNumber", value = "目的号码", required = true)
    @RequestParam(value = "destinationPhoneNumber", required = true) String destinationPhoneNumber,
            @ApiParam(name = "SMSContent", value = "短信内容", required = true)
            @RequestParam(value = "SMSContent", required = true) String SMSContent,
            @ApiParam(name = "SMSSender", value = "短信发送方", required = true)
            @RequestParam(value = "SMSSender", required = true) String SMSSender) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.SMSDeliver(destinationPhoneNumber, SMSContent, SMSSender);

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
    @RequestMapping("/check_cellphone_location2")
    @ApiOperation(value = "联通、电信运营商位置核验（仅提供银行机构）",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "联通、电信运营商位置核验（仅提供银行机构）")
    public JsonBean check_cellphone_location2(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber,
            @ApiParam(name = "longitude", value = "经度", required = true)
            @RequestParam(value = "longitude", required = true) String longitude,
            @ApiParam(name = "latitude", value = "纬度", required = true)
            @RequestParam(value = "latitude", required = true) String latitude) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkCellphoneLocation2(personName, identityType, identityNumber,
                    cellPhoneNumber, longitude, latitude);

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
    @RequestMapping("/check_blacklist_merchant_T2")
    @ApiOperation(value = "银联风险收单商户识别", httpMethod = "POST", response = JsonBean.class, notes = "银联风险收单商户识别")
    public JsonBean check_blacklist_merchant_T2(@ApiParam(name = "merchantName", value = "商户名", required = true)
    @RequestParam(value = "merchantName", required = true) String merchantName,
            @ApiParam(name = "merchantIdType", value = "商户标识类型", required = true)
            @RequestParam(value = "merchantIdType", required = true) String merchantIdType,
            @ApiParam(name = "merchantId", value = "真实商户编号", required = false)
            @RequestParam(value = "merchantId", required = false) String merchantId,
            @ApiParam(name = "uniformCreditCode", value = "手机号码", required = true)
            @RequestParam(value = "uniformCreditCode", required = true) String uniformCreditCode) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkBlacklistMerchantT2(merchantName, merchantIdType, merchantId,
                    uniformCreditCode);

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
    @RequestMapping("/uni_roaming_times")
    @ApiOperation(value = "联通用户平均通话量评分", httpMethod = "POST", response = JsonBean.class, notes = "联通用户平均通话量评分")
    public JsonBean uni_roaming_times(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.uniRoamingTimes(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/uni_monthly_consumption")
    @ApiOperation(value = "联通用户平均话费评分", httpMethod = "POST", response = JsonBean.class, notes = "联通用户平均话费评分")
    public JsonBean uni_monthly_consumption(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.uniMonthlyConsumption(personName, identityType, identityNumber,
                    cellPhoneNumber);

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
    @RequestMapping("/uni_monthly_data_usage")
    @ApiOperation(value = "联通用户平均流量评分", httpMethod = "POST", response = JsonBean.class, notes = "联通用户平均流量评分")
    public JsonBean uni_monthly_data_usage(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.uniMonthlyDataUsage(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/uni_last_using_time")
    @ApiOperation(value = "联通最后一次活跃情况查询", httpMethod = "POST", response = JsonBean.class, notes = "联通最后一次活跃情况查询")
    public JsonBean uni_last_using_time(@ApiParam(name = "personName", value = "姓名", required = true)
    @RequestParam(value = "personName", required = true) String personName,
            @ApiParam(name = "identityType", value = "证件类型", required = true)
            @RequestParam(value = "identityType", required = true) String identityType,
            @ApiParam(name = "identityNumber", value = "证件号码", required = true)
            @RequestParam(value = "identityNumber", required = true) String identityNumber,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.uniLastUsingTime(personName, identityType, identityNumber, cellPhoneNumber);

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
    @RequestMapping("/check_personal_account_info_2")
    @ApiOperation(value = "银行卡两要素信息验证", httpMethod = "POST", response = JsonBean.class, notes = "银行卡两要素信息验证")
    public JsonBean check_personal_account_info_2(@ApiParam(name = "personName", value = "姓名", required = false)
    @RequestParam(value = "personName", required = false) String personName,
            @ApiParam(name = "cellPhoneNumber", value = "手机号码", required = true)
            @RequestParam(value = "cellPhoneNumber", required = true) String cellPhoneNumber) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = cfcaServiceImpl.checkPersonalAccountInfo(personName, cellPhoneNumber);

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
