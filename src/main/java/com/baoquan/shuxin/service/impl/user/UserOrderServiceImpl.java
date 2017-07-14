package com.baoquan.shuxin.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.user.UserOrderDao;
import com.baoquan.shuxin.model.user.UserOrder;
import com.baoquan.shuxin.service.spi.user.UserOrderService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:16:11 ${DATA}
 */
@Named
public class UserOrderServiceImpl<T> implements UserOrderService {


    @Inject
    private UserOrderDao userOrderDao;


    @Override
    public Page<UserOrder> querListUserOrderInfo(Long userId, Integer status, Long buyTime, Page<UserOrder> page) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("userId",userId);
        parms.put("status",status);
        parms.put("buyTime",buyTime);
        parms.put("page", page);
        List<UserOrder> listInfo = userOrderDao.querUserOrderInfo(parms);
        Integer total = userOrderDao.PageCount(parms);
        if (total != null) {
            page.setTotalRecordCount(total);
        }
        page.setResult(listInfo);
        return page;
    }
}
