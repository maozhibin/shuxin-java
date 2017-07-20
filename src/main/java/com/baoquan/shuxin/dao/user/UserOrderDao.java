package com.baoquan.shuxin.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserOrder;


/**
 * Author:Zhoumc
 * Description:订单
 * DATA:15:37
 */
@Repository
public interface UserOrderDao {
    List<UserOrder> querUserOrderInfo(Map<String, Object> parm);

    Integer pageCount(Map<String, Object> parms);

    UserOrderDao querByIdUserOrderInfo(Long id);
}
