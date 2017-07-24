package com.baoquan.shuxin.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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

    Integer countFlowInfo(@Param("userId") Long userId,@Param("status") Integer status,@Param("statTime") Long starTime,@Param("endTime") Long endTime);

    UserOrderDao querByIdUserOrderInfo(Long id);
}
