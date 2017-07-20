package com.baoquan.shuxin.web.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.baoquan.shuxin.model.user.UserOrder;
import com.baoquan.shuxin.service.spi.news.OptionService;
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

    @Inject
    private OptionService optionService;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(Long userId, Integer status,String buyTime ,String pageNo,
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

        String buy = buyTime;
        Long statTime = null;
        Long endTime = null;
       if (StringUtils.isNotEmpty(buy)){
         String star = buy.substring(0,10);
           String end = buy.substring(12,buy.length());
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           try{
               statTime = sdf.parse(star).getTime();
               endTime = sdf.parse(end).getTime();
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
        UserOrder userOrder = new UserOrder();


        List<Option> order = optionService.queryOrderInfo();
        page = orderService.querListUserOrderInfo(userId, status,statTime, endTime, page);

        mv.addObject("order",order);
        mv.addObject(page);
        return mv;
    }


}
