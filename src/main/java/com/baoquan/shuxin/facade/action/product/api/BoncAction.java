package com.baoquan.shuxin.facade.action.product.api;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.service.spi.product.api.BoncService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/5/2.
 */
@Controller
@RequestMapping("/bonc")
@Api(value = "bonc-api", description = "东方国信", position = 0)
public class BoncAction {
    @Inject
    private BoncService boncServiceImpl;

    @ResponseBody
    @RequestMapping("/group_name_flag")
    @ApiOperation(value = "集团客户验证（电信）（涉及到的短号情况（集团号、亲情号等））",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "集团客户验证（电信）（涉及到的短号情况（集团号、亲情号等））")
    public JsonBean group_name_flag(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = boncServiceImpl.groupNameFlag(mobile);

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
    @RequestMapping("/talk_time_length_label")
    @ApiOperation(value = "获取指定月通话时长阶梯（电信）（手机月均通话时长）",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "获取指定月通话时长阶梯（电信）（手机月均通话时长）")
    public JsonBean talk_time_length_label(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "month", value = "年月", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = boncServiceImpl.talkTimeLengthLabel(mobile, month);

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
    @RequestMapping("/call_count_top5_label")
    @ApiOperation(value = "获取TOP5联系人主叫通话次数（电信）（频繁通话人数）",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "获取TOP5联系人主叫通话次数（电信）（频繁通话人数）")
    public JsonBean call_count_top5_label(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "month", value = "年月", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = boncServiceImpl.callCountTop5Label(mobile, month);

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
    @RequestMapping("/roam_count_in_3months_label")
    @ApiOperation(value = "手机号码最近三个月漫游次数/分级（电信）（漫游通话占比）",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "手机号码最近三个月漫游次数/分级（电信）（漫游通话占比）")
    public JsonBean roam_count_in_3months_label(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "month", value = "年月", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = boncServiceImpl.roamCountIn3MonthsLabel(mobile, month);

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
    @RequestMapping("/talk_time_length_dawn_ptg_score")
    @ApiOperation(value = "手机号码-指定月凌晨时段通话时长占比得分、（电信）（通话时间点分布（如晚上九点以后通话时间比例））",
                  httpMethod = "POST",
                  response = JsonBean.class,
                  notes = "手机号码-指定月凌晨时段通话时长占比得分、（电信）（通话时间点分布（如晚上九点以后通话时间比例））")
    public JsonBean talk_time_length_dawn_ptg_score(
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "month", value = "年月", required = true) @RequestParam(value = "month", required = true)
                    String month) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = boncServiceImpl.talkTimeLengthDawnPtgScore(mobile, month);

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
