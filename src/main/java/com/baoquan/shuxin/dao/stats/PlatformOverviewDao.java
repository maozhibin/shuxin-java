package com.baoquan.shuxin.dao.stats;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Desc:
 * Created by yongj on 7/24/2017,
 */
@Repository
public interface PlatformOverviewDao {
    //总交易额
    BigDecimal sumMoneyLogByTime(@Param("startTime") long startTime, @Param("endTime") long endTime);

    //总订单量
    Long countUserProductByTime(@Param("startTime") long startTime, @Param("endTime") long endTime);

    //存证总数
    Long countSecurityBaoquanLogByTime(@Param("startTime") long startTime, @Param("endTime") long endTime);

    //授权总量
    Long countAuthorizationByTime(@Param("startTime") long startTime, @Param("endTime") long endTime);
}
