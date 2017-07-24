package com.baoquan.shuxin.web.controller.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
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
    public Object list(Long userId, String type, String date_range, Integer pageNo, Integer pageSize) {
            ModelAndView mv = new ModelAndView("admin/account/account_index");
            if (pageNo == null || pageNo < 1)  pageNo = 1;
            if (pageSize == null || pageSize > 15) pageSize = 15;
            Page page = new Page();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            //截取时间 转换为时间撮
            String range = date_range;
            Long statTime = null;
            Long endTime = null;
            if (StringUtils.isNotEmpty(range)) {
                String stat = range.substring(0, 10);
                String end = range.substring(12, range.length());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    statTime = sdf.parse(stat).getTime() / 1000;
                    endTime = sdf.parse(end).getTime() / 1000;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            Integer flowCount = accountFlowService.countFlowInfo(userId, type, statTime, endTime);
            page.setTotalRecordCount(flowCount);
            if (flowCount > 0) {
                List<AccountFlow> flowList = accountFlowService.querListAccountFlowInfo(userId, type, statTime, endTime,
                        (pageNo - 1) * pageSize, pageSize);


                List<Option> optionList = optionService.queryFlowInfo();

                List<FlowVO> flowVOList = new ArrayList<>(flowList.size());

                for (AccountFlow flow : flowList) {
                    String typeName = flow.getType();
                    Option op = null;
                    for(Option option: optionList){
                       if(typeName.equals(option.getValue())  ){
                           op = option;
                           break;
                       }
                    }
                    FlowVO f = buildFlowInfoVO(flow,op);
                    flowVOList.add(f);
                }

                page.setResult(flowVOList);
            }

            mv.addObject(page);
            mv.addObject("flow", optionService.queryFlowInfo());
            mv.addObject("startTime", System.currentTimeMillis() - 1234567890);
            mv.addObject("endTime", System.currentTimeMillis());
            return mv;
        }

    private FlowVO buildFlowInfoVO(AccountFlow flow,Option option){
        FlowVO vo = new FlowVO();
        vo.setUserId(flow.getUserId());
        vo.setAmount(flow.getAmount());
        vo.setStatus(flow.getStatus());
        vo.setRequestNo(flow.getRequestNo());
        vo.setFee(flow.getFee());
        vo.setStatusDesc(flow.getStatusDesc());
        vo.setTypeName(option.getName());
        if(flow.getDateline() != null){
            vo.setDateline(new Date(flow.getDateline()));
        }
        if(flow.getFinishTime() != null){
            vo.setFinishTime(new Date(flow.getFinishTime()) );
        }
        return vo;
    }






}