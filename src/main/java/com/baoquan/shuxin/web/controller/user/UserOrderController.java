package com.baoquan.shuxin.web.controller.user;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.model.user.UserOrder;
import com.baoquan.shuxin.service.spi.user.UserOrderService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:16:39 ${DATA}
 */
@RequestMapping("/order")
@Controller
public class UserOrderController {

    @Inject
    private UserOrderService orderService;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(Long userId, Integer status,Long buyTime ,String pageNo,
            String pageSize ){
        ModelAndView mv = new ModelAndView("admin/order/order_index");
        Page<UserOrder> page = new Page<UserOrder>();

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
        page = orderService.querListUserOrderInfo(userId, status,buyTime , page);
        mv.addObject(page);
        return mv;
    }


}
