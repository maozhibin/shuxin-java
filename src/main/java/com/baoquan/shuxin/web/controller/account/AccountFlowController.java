package com.baoquan.shuxin.web.controller.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.model.account.FlowVO;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.account.AccountFlowService;
import com.baoquan.shuxin.service.spi.news.OptionService;

/**
 * Author:Zhoumc
 * Description: 账单流水
 * DATA:11:21
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
    public Object list(Long userId, String type, String date_range, Integer pageNo, Integer pageSize) {
        ModelAndView mv = new ModelAndView("admin/account/account_index");

        if (pageNo == null || pageNo < 1) pageNo = 1;
        if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
        type = StringUtils.trimToNull(type);

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        String range = date_range;
        //截取时间 转换为时间戳
        Long statTime = null;
        Long endTime = null;
        if (StringUtils.isNotEmpty(range)) {
            String stat = range.substring(0, 10);
            String end = range.substring(12, range.length());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                statTime = sdf.parse(stat).getTime() / 1000;
                //开始时间为所选日期的0点开始，结束时间为所选日期的23：59:59
                Date date = sdf.parse(end);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.set(Calendar.HOUR_OF_DAY, 23);
                c.set(Calendar.MINUTE, 59);
                c.set(Calendar.SECOND, 59);
                endTime = c.getTime().getTime()/1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            //进入默认赋值当天时间和当前时间查询（当天时间指的是0点到系统当前时间，两个时间点）
            //获取当天0点时间戳
            Date date = new Date();
            Date today = DateUtils.truncate(date, Calendar.DATE);
            statTime = today.getTime()/1000;
            //获取系统当前时间戳
            endTime = date.getTime()/1000;
        }
        List<Option> optionList = optionService.queryFlowInfo();
        Integer flowCount = accountFlowService.countFlowInfo(userId, type,statTime, endTime);
        page.setTotalRecordCount(flowCount);
        if (flowCount > (pageNo - 1) * pageSize) {
            List<AccountFlow> flowList = accountFlowService.querListAccountFlowInfo(userId, type, statTime, endTime,
                    (pageNo - 1) * pageSize, pageSize);

            List<FlowVO> flowVOList = new ArrayList<>(flowList.size());
            for (AccountFlow flow : flowList) {
                String typeName = flow.getType();
                Option op = null;
                for (Option option : optionList) {
                    if (typeName.equals(option.getValue())) {
                        op = option;
                        break;
                    }
                }
                FlowVO f = buildFlowInfoVO(flow, op);
                flowVOList.add(f);
            }
            page.setResult(flowVOList);
        }
        mv.addObject(page);
        mv.addObject("flow", optionList);
        mv.addObject("startTime", statTime != null ? statTime * 1000 : null);
        mv.addObject("endTime", endTime != null ? endTime * 1000 : null);
        mv.addObject("type", type);
        mv.addObject("userId",userId);
        return mv;
    }

    private FlowVO buildFlowInfoVO(AccountFlow flow, Option option) {
        FlowVO vo = new FlowVO();
        vo.setUserId(flow.getUserId());
        vo.setAmount(flow.getAmount());
        vo.setStatus(flow.getStatus());
        vo.setRequestNo(flow.getRequestNo());
        vo.setFee(flow.getFee());
        vo.setStatusDesc(flow.getStatusDesc());
        if(!StringUtils.isNotEmpty(option.getName())){
            vo.setTypeName("");
        }else {
            vo.setTypeName(option.getName());
        }

        if (flow.getDateline() != null) {
            vo.setDateline(flow.getDateline());
        }
        if (flow.getFinishTime() != null) {
            vo.setFinishTime(flow.getFinishTime());
        }
        return vo;
    }


}