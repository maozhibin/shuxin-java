package com.baoquan.shuxin.web.controller.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.account.AccountFlowService;
import com.baoquan.shuxin.service.spi.news.OptionService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:11:21 ${DATA}
 */
@Controller
@RequestMapping("/account")
public class AccountFlowController {

    @Inject
    private AccountFlowService accountFlowService;


    @Inject
    private OptionService optionService;

    @RequestMapping("/flow")
    @ResponseBody
    public ModelAndView accountFlowInfo(Long userId, String type, String date_range ,String pageNo,
            String pageSize ){
        ModelAndView mv = new ModelAndView("admin/account/account_index");
        Page<AccountFlow> page = new Page<AccountFlow>();
        Integer pageSizeValue = null;
        if (NumberUtils.isNumber(pageSize)) {
            pageSizeValue = NumberUtils.toInt(pageSize);
            page.setPageSize(pageSizeValue);
        }
        Integer pageNoValue = null;
        if (NumberUtils.isNumber(pageNo)) {
            pageNoValue = NumberUtils.toInt(pageNo);
            page.setPageNo(pageNoValue);
        }
        String range = date_range;
        Long statTime = null;
        Long endTime = null;
        if(StringUtils.isNotEmpty(range)){
            String stat = range.substring(0,10);
            String end = range.substring(12,range.length());
            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                statTime = sdf.parse(stat).getTime();
                endTime = sdf.parse(end).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<Option> flow = optionService.queryFlowInfo();
        page = accountFlowService.querListAccountFlowInfo(userId, type,statTime,endTime, page);
        mv.addObject(page);
        mv.addObject("flow",flow);
        mv.addObject("startTime", System.currentTimeMillis() - 1234567890);
        mv.addObject("endTime", System.currentTimeMillis());
        return mv;
    }


}
