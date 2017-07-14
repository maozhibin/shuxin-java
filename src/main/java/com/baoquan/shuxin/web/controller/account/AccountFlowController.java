package com.baoquan.shuxin.web.controller.account;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.account.AccountFlowService;

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



    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView accountFlowInfo(Long userId, String type, Long dateline, Long finishTime,String pageNo,
            String pageSize ){
        ModelAndView mv = new ModelAndView("admin/account/list");
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
        page = accountFlowService.querListAccountFlowInfo(userId, type, dateline,finishTime, page);
        mv.addObject(page);
        return mv;
    }

}