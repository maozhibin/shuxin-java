package com.baoquan.shuxin.web.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.user.UserOrder;
import com.baoquan.shuxin.model.user.UserOrderVO;
import com.baoquan.shuxin.service.spi.news.OptionService;
import com.baoquan.shuxin.service.spi.product.ProductService;
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

    @Inject
    private ProductService productService;



    @RequestMapping("/list")
    @ResponseBody
    public Object list(Long userId, Integer status,String date_range ,Integer pageNo,
            Integer pageSize ){
        ModelAndView mv = new ModelAndView("admin/order/order_index");
        if (pageNo == null || pageNo < 1)  pageNo = 1;
        if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        String buy = date_range;
        Long statTime = null;
        Long endTime = null;
       if (StringUtils.isNotEmpty(buy)){
         String star = buy.substring(0,10);
           String end = buy.substring(12,buy.length());
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           try{
               statTime = sdf.parse(star).getTime()/1000;
               endTime = sdf.parse(end).getTime()/1000;
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }

        Integer orderCount = orderService.countOrderInfo(userId, status,statTime, endTime);
        page.setTotalRecordCount(orderCount);
        if (orderCount >(pageNo - 1) * pageSize ) {
            List<UserOrder> userOrderList = orderService.querListUserOrderInfo(userId, status, statTime, endTime,
                    (pageNo - 1) * pageSize, pageSize);
            List<UserOrderVO> userOrderVOList = new ArrayList<>(userOrderList.size());

            for (UserOrder userOrder : userOrderList) {
                int id = userOrder.getProductId();
                Product productIdList = productService.findById(id);
                String statusName = String.valueOf(userOrder.getStatus());
                List<Option> optionList = optionService.queryOrderInfo();
                Option op = null;
                for (Option option : optionList) {
                    if (statusName.equals(option.getValue())) {
                        op = option;
                        break;
                    }

                }
                UserOrderVO userOrderVO = buildOrderInfoVO(userOrder, productIdList,op);
                userOrderVOList.add(userOrderVO);
                page.setResult(userOrderVOList);
            }

        }
        mv.addObject(page);
        mv.addObject("userId", userId);
        mv.addObject("status", status);
        mv.addObject("order", optionService.queryOrderInfo());
        mv.addObject("startTime", statTime != null ? statTime * 1000 : null);
        mv.addObject("endTime", endTime != null ? endTime * 1000 : null);
        return mv;
    }

    private UserOrderVO buildOrderInfoVO(UserOrder userOrder,Product pd,Option op){
        UserOrderVO vo = new UserOrderVO();
        vo.setUserId(userOrder.getUserId());
        if(op.getName() != null){
            vo.setStatuName(op.getName());
        }
        vo.setName(pd.getName());
        vo.setBuyAmount(userOrder.getBuyAmount());
        vo.setPayAmount(userOrder.getPayAmount());
        if (userOrder.getRequestNo() !=null){
            vo.setRequestNo(userOrder.getRequestNo());
        }
        vo.setBuyTime(userOrder.getBuyTime());

        return vo;
    }


}
