package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.GeotmtService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/geotmt")
@Api(value = "geotmt-api", description = "geotmt-API", position = 0)
public class GeotmtAction {

    @Inject
    private GeotmtService geotmtServiceImpl;

//	@Inject
//	private RedisService<String> stringRedisService;

    @ResponseBody
    @RequestMapping("/real_1_dimension_name_verify")
    @ApiOperation(value = "手机号码实名制验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号码实名制验证")
    public JsonBean real_1_dimension_name_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.real_1_dimension_name_verify(cid, idNumber, realName);
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
    @RequestMapping("/real_2_dimension_name_verify")
    @ApiOperation(value = "手机号码姓名验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号码实名制验证")
    public JsonBean real_2_dimension_name_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.real_2_dimension_name_verify(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_online_time")
    @ApiOperation(value = "手机在网时长查询", httpMethod = "POST", response = JsonBean.class, notes = "手机在网时长查询")
    public JsonBean cellphone_online_time(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_online_time(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_online_status")
    @ApiOperation(value = "手机当前状态查询", httpMethod = "POST", response = JsonBean.class, notes = "手机当前状态查询")
    public JsonBean cellphone_online_status(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_online_status(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_own_numbers")
    @ApiOperation(value = "手机号码自然人接入号码个数查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号码自然人接入号码个数查询")
    public JsonBean cellphone_own_numbers(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_own_numbers(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_change_frequency")
    @ApiOperation(value = "手机号码换机频率", httpMethod = "POST", response = JsonBean.class, notes = "手机号码换机频率")
    public JsonBean cellphone_change_frequency(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_change_frequency(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_month_consumption")
    @ApiOperation(value = "手机号码换月消费档次查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号码换月消费档次查询")
    public JsonBean cellphone_month_consumption(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_month_consumption(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_3month_consumption_sum")
    @ApiOperation(value = "手机号码消费总额查询（三个月缴费均值）",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "手机号码消费总额查询（三个月缴费均值）")
    public JsonBean cellphone_3month_consumption_sum(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "month", value = "指定月份", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_3month_consumption_sum(cid, idNumber, realName, month);
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
    @RequestMapping("/cellphone_location")
    @ApiOperation(value = "手机号码常驻地验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号码消费总额查询（三个月缴费均值）")
    public JsonBean cellphone_location(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "usualaddress", value = "常驻地址", required = true)
            @RequestParam(value = "usualaddress", required = true) String usualaddress) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_location(cid, idNumber, realName, usualaddress);
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
    @RequestMapping("/real_3_dimension_name_verify")
    @ApiOperation(value = "手机号码身份证姓名验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号码实名制验证")
    public JsonBean real_3_dimension_name_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.real_3_dimension_name_verify(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_work_location")
    @ApiOperation(value = "手机号工作时段地址查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号工作时段地址查询")
    public JsonBean cellphone_work_location(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_work_location(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_frequent_contacts_verify")
    @ApiOperation(value = "手机号码常用联系人验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号码常用联系人验证")
    public JsonBean cellphone_frequent_contacts_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "cid2", value = "常用联系人", required = true) @RequestParam(value = "cid2", required = true)
                    String cid2) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_frequent_contacts_verify(cid, idNumber, realName, cid2);
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
    @RequestMapping("/cellphone_3_month_stop")
    @ApiOperation(value = "手机号最近三月停机次数查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号最近三月停机次数查询")
    public JsonBean cellphone_3_month_stop(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_3_month_stop(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_arrears")
    @ApiOperation(value = "手机号欠费状态查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号欠费状态查询")
    public JsonBean cellphone_arrears(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_arrears(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_rest_location")
    @ApiOperation(value = "手机号休息时段地址查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号休息时段地址查询")
    public JsonBean cellphone_rest_location(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号码", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = geotmtServiceImpl.cellphone_rest_location(cid, idNumber, realName);
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
    @RequestMapping("/cellphone_work_location_offset")
    @ApiOperation(value = "手机号工作时段地址偏移量", httpMethod = "POST", response = JsonBean.class, notes = "手机号工作时段地址偏移量")
    public JsonBean cellphone_work_location_offset(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "innerIfType", value = "接口类型", required = true)
            @RequestParam(value = "innerIfType", required = true) String innerIfType,
            @ApiParam(name = "longitude", value = "经度", required = true)
            @RequestParam(value = "longitude", required = true) String longitude,
            @ApiParam(name = "latitude", value = "纬度", required = true)
            @RequestParam(value = "latitude", required = true) String latitude) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_work_location_offset(cid, idNumber, realName, longitude, latitude);

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
    @RequestMapping("/cellphone_rest_location_offset")
    @ApiOperation(value = "手机号工作时段地址偏移量", httpMethod = "POST", response = JsonBean.class, notes = "手机号工作时段地址偏移量")
    public JsonBean cellphone_rest_location_offset(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "longitude", value = "经度", required = true)
            @RequestParam(value = "longitude", required = true) String longitude,
            @ApiParam(name = "latitude", value = "纬度", required = true)
            @RequestParam(value = "latitude", required = true) String latitude) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_rest_location_offset(cid, idNumber, realName, longitude, latitude);

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
    @RequestMapping("/cellphone_realtime_location_offset")
    @ApiOperation(value = "手机号实时位置偏移量", httpMethod = "POST", response = JsonBean.class, notes = "手机号实时位置偏移量")
    public JsonBean cellphone_realtime_location_offset(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "longitude", value = "经度", required = true)
            @RequestParam(value = "longitude", required = true) String longitude,
            @ApiParam(name = "latitude", value = "纬度", required = true)
            @RequestParam(value = "latitude", required = true) String latitude) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_realtime_location_offset(cid, idNumber, realName, longitude,
                    latitude);

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
    @RequestMapping("/cellphone_month_data_usage")
    @ApiOperation(value = "手机号实时位置偏移量", httpMethod = "POST", response = JsonBean.class, notes = "手机号实时位置偏移量")
    public JsonBean cellphone_month_data_usage(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_month_data_usage(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_age")
    @ApiOperation(value = "手机号码自然人年龄查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号码自然人年龄查询")
    public JsonBean cellphone_age(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_age(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_gender")
    @ApiOperation(value = "手机号码自然人性别查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号码自然人性别查询")
    public JsonBean cellphone_gender(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_gender(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_month_top_call_city")
    @ApiOperation(value = "手机号指定月通话天数最多的城市", httpMethod = "POST", response = JsonBean.class, notes = "手机号指定月通话天数最多的城市")
    public JsonBean cellphone_month_top_call_city(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "month", value = "月份", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_month_top_call_city(cid, idNumber, realName, month);

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
    @RequestMapping("/cellphone_month_payment")
    @ApiOperation(value = "手机号月度缴费总额", httpMethod = "POST", response = JsonBean.class, notes = "手机号月度缴费总额")
    public JsonBean cellphone_month_payment(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_month_payment(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_terminal_type")
    @ApiOperation(value = "手机号终端型号查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号终端型号查询")
    public JsonBean cellphone_terminal_type(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_terminal_type(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_contract_count")
    @ApiOperation(value = "手机号联系人通话次数查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号联系人通话次数查询")
    public JsonBean cellphone_contract_count(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "cid2", value = "联系人手机号", required = true) @RequestParam(value = "cid2", required = true)
                    String cid2) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_contract_count(cid, idNumber, realName, cid2);

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
    @RequestMapping("/cellphone_identity_verify")
    @ApiOperation(value = "手机号身份证号验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号身份证号验证")
    public JsonBean cellphone_identity_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_identity_verify(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_company_verify")
    @ApiOperation(value = "手机号集团客户验证", httpMethod = "POST", response = JsonBean.class, notes = "手机号集团客户验证")
    public JsonBean cellphone_company_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_company_verify(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_prepaid")
    @ApiOperation(value = "手机号预/后付费查询-电信", httpMethod = "POST", response = JsonBean.class, notes = "手机号预/后付费查询-电信")
    public JsonBean cellphone_prepaid(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_prepaid(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_month_arrears")
    @ApiOperation(value = "手机号指定月欠费总额查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号指定月欠费总额查询")
    public JsonBean cellphone_month_arrears(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName,
            @ApiParam(name = "month", value = "月份", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_month_arrears(cid, idNumber, realName, month);

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
    @RequestMapping("/cellphone_blacklist_verify")
    @ApiOperation(value = "手机号黑名单验证(当前欠费不交超过3个月)",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "手机号黑名单验证" + "(当前欠费不交超过3个月)")
    public JsonBean cellphone_blacklist_verify(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_blacklist_verify(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_user_level")
    @ApiOperation(value = "手机号用户等级-电信", httpMethod = "POST", response = JsonBean.class, notes = "手机号用户等级-电信")
    public JsonBean cellphone_user_level(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_user_level(cid, idNumber, realName);

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
    @RequestMapping("/financial_stability_evaluation")
    @ApiOperation(value = "金融稳定性评价查询", httpMethod = "POST", response = JsonBean.class, notes = "金融稳定性评价查询")
    public JsonBean financial_stability_evaluation(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = false)
    @RequestParam(value = "idNumber", required = false) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = false)
            @RequestParam(value = "realName", required = false) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.financial_stability_evaluation(cid, idNumber, realName);

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
    @RequestMapping("/highest_education")
    @ApiOperation(value = "最高学历查询", httpMethod = "POST", response = JsonBean.class, notes = "最高学历查询")
    public JsonBean highest_education(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.highest_education(cid, idNumber, realName);

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
    @RequestMapping("/name_identity_verify")
    @ApiOperation(value = "姓名身份证号验证", httpMethod = "POST", response = JsonBean.class, notes = "姓名身份证号验证")
    public JsonBean name_identity_verify(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.name_identity_verify(cid, idNumber, realName);

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
    @RequestMapping("/name_identity_verify_with_photo")
    @ApiOperation(value = "姓名身份证号验证(带照片)", httpMethod = "POST", response = JsonBean.class, notes = "姓名身份证号验证(带照片)")
    public JsonBean name_identity_verify_with_photo(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.name_identity_verify_with_photo(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_dishonest")
    @ApiOperation(value = "身份证号命中法院失信名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中法院失信名单")
    public JsonBean identity_hit_dishonest(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_dishonest(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_execution")
    @ApiOperation(value = "身份证号命中法院执行名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中法院执行名单")
    public JsonBean identity_hit_execution(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_execution(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_after_loan_management")
    @ApiOperation(value = "身份证号命中委托贷后管理名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中委托贷后管理名单")
    public JsonBean identity_hit_after_loan_management(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_after_loan_management(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_blacklist")
    @ApiOperation(value = "身份证号命中互联网灰名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中互联网灰名单")
    public JsonBean identity_hit_blacklist(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_blacklist(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_drag_or_fugitive")
    @ApiOperation(value = "身份证号命中吸毒/在逃关注名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中吸毒/在逃关注名单")
    public JsonBean identity_hit_drag_or_fugitive(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_drag_or_fugitive(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_fraud")
    @ApiOperation(value = "身份证号命中恶意欺诈关注名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中恶意欺诈关注名单")
    public JsonBean identity_hit_fraud(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_fraud(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_bank")
    @ApiOperation(value = "身份证号命中银行关注名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中银行关注名单")
    public JsonBean identity_hit_bank(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_bank(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_insurance_fraud")
    @ApiOperation(value = "身份证号命中保险欺诈关注名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中保险欺诈关注名单")
    public JsonBean identity_hit_insurance_fraud(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_insurance_fraud(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_p2p")
    @ApiOperation(value = "身份证号命中p2p关注名单", httpMethod = "POST", response = JsonBean.class, notes = "身份证号命中p2p关注名单")
    public JsonBean identity_hit_p2p(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_p2p(cid, idNumber, realName);

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
    @RequestMapping("/identity_hit_overdue")
    @ApiOperation(value = "身份证号命中金融逾期/拒绝关注名单",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "身份证号命中金融逾期/拒绝关注名单")
    public JsonBean identity_hit_overdue(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_hit_overdue(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_dishonest")
    @ApiOperation(value = "手机号命中法院失信名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中法院失信名单")
    public JsonBean cellphone_hit_dishonest(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_dishonest(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_execution")
    @ApiOperation(value = "手机号命中法院执行名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中法院执行名单")
    public JsonBean cellphone_hit_execution(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_execution(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_blacklist")
    @ApiOperation(value = "手机号命中互联网灰名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中互联网灰名单")
    public JsonBean cellphone_hit_blacklist(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_blacklist(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_drag_or_fugitive")
    @ApiOperation(value = "手机号命中吸毒/在逃关注名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中吸毒/在逃关注名单")
    public JsonBean cellphone_hit_drag_or_fugitive(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_drag_or_fugitive(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_fraud")
    @ApiOperation(value = "手机号命中恶意欺诈关注名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中恶意欺诈关注名单")
    public JsonBean cellphone_hit_fraud(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_fraud(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_bank")
    @ApiOperation(value = "手机号命中银行关注名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中银行关注名单")
    public JsonBean cellphone_hit_bank(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_bank(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_insurance_fraud")
    @ApiOperation(value = "手机号命中保险欺诈关注名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中保险欺诈关注名单")
    public JsonBean cellphone_hit_insurance_fraud(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_insurance_fraud(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_p2p")
    @ApiOperation(value = "手机号命中p2p关注名单", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中p2p关注名单")
    public JsonBean cellphone_hit_p2p(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_p2p(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_overdue")
    @ApiOperation(value = "手机号命中金融逾期/拒绝关注名单",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "手机号命中金融逾期/拒绝关注名单")
    public JsonBean cellphone_hit_overdue(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_overdue(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_hit_intermediary")
    @ApiOperation(value = "手机号命中换联网贷款中介", httpMethod = "POST", response = JsonBean.class, notes = "手机号命中换联网贷款中介")
    public JsonBean cellphone_hit_intermediary(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_hit_intermediary(cid, idNumber, realName);

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
    @RequestMapping("/overdue_query")
    @ApiOperation(value = "逾期信息查询", httpMethod = "POST", response = JsonBean.class, notes = "逾期信息查询")
    public JsonBean overdue_query(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "cycle", value = "周期", required = true) @RequestParam(value = "cycle", required = true)
                    String cycle, @ApiParam(name = "realName", value = "姓名", required = true)
    @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.overdue_query(cid, idNumber, cycle, realName);

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
    @RequestMapping("/identity_3_day_apply")
    @ApiOperation(value = "身份证3天申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "身份证3天申请机构数量查询")
    public JsonBean identity_3_day_apply(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_3_day_apply(cid, idNumber, realName);

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
    @RequestMapping("/identity_7_day_apply")
    @ApiOperation(value = "身份证7天申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "身份证7天申请机构数量查询")
    public JsonBean identity_7_day_apply(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_7_day_apply(cid, idNumber, realName);

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
    @RequestMapping("/identity_1_month_apply")
    @ApiOperation(value = "身份证1个月内申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "身份证1个月内申请机构数量查询")
    public JsonBean identity_1_month_apply(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_1_month_apply(cid, idNumber, realName);

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
    @RequestMapping("/identity_3_month_apply")
    @ApiOperation(value = "身份证3个月内申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "身份证3个月内申请机构数量查询")
    public JsonBean identity_3_month_apply(
            @ApiParam(name = "cid", value = "手机号码", required = false) @RequestParam(value = "cid", required = false)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.identity_3_month_apply(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_3_day_apply")
    @ApiOperation(value = "手机号3天申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号3天申请机构数量查询")
    public JsonBean cellphone_3_day_apply(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_3_day_apply(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_7_day_apply")
    @ApiOperation(value = "手机号7天申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号7天申请机构数量查询")
    public JsonBean cellphone_7_day_apply(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_7_day_apply(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_1_month_apply")
    @ApiOperation(value = "手机号1个月内申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号1个月内申请机构数量查询")
    public JsonBean cellphone_1_month_apply(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_1_month_apply(cid, idNumber, realName);

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
    @RequestMapping("/cellphone_3_month_apply")
    @ApiOperation(value = "手机号3个月内申请机构数量查询", httpMethod = "POST", response = JsonBean.class, notes = "手机号3个月内申请机构数量查询")
    public JsonBean cellphone_3_month_apply(
            @ApiParam(name = "cid", value = "手机号码", required = true) @RequestParam(value = "cid", required = true)
                    String cid, @ApiParam(name = "idNumber", value = "身份证号", required = true)
    @RequestParam(value = "idNumber", required = true) String idNumber,
            @ApiParam(name = "realName", value = "姓名", required = true)
            @RequestParam(value = "realName", required = true) String realName) {
        JsonBean jsonBean = new JsonBean();
        try {

            String str = geotmtServiceImpl.cellphone_3_month_apply(cid, idNumber, realName);

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