package com.baoquan.shuxin.service.spi.user;

import java.util.List;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.model.user.UserOrder;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:55
 */
public interface UserOrderService {

    /**
     * 根据条件分页查询账户
     * @param userId 用户id
     * @return
     */
    List<UserOrder> querListUserOrderInfo(Long userId,Integer status,Long statTime,Long endTime,Integer start, Integer length);

    //默认查询
    Integer countOrderInfo(Long userId,Integer status,Long statTime,Long endTime);


}
