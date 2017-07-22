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
public class UserOrderServiceImpl implements UserOrderService {


    @Inject
    private UserOrderDao userOrderDao;


    @Override
    public List<UserOrder> querListUserOrderInfo(Long userId, Integer status, Long starTime,Long endTime,Integer start, Integer length) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("userId",userId);
        parms.put("status",status);
        parms.put("starTime",starTime);
        parms.put("endTime",endTime);
        parms.put("start",start);
        parms.put("length",length);
        return userOrderDao.querUserOrderInfo(parms);
    }

    @Override
    public Integer countOrderInfo(Long userId, Integer status, Long statTime, Long endTime) {
        return userOrderDao.countFlowInfo(userId,status,statTime,endTime);
    }


}
