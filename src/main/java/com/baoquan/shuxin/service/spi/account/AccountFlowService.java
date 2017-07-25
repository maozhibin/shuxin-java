package com.baoquan.shuxin.service.spi.account;

import java.math.BigDecimal;
import java.util.List;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.account.AccountFlow;

/**
 * Author:
 * Description:${TODO}
 * DATA:9:54 ${DATA}
 */
public interface AccountFlowService {
    /**
     * 查询账户 id
     * @param id
     * @return
     */
    AccountFlow querListByIdAccountFlow(Long id);


    /**
     * 根据条件分页查询账户
     * @param userId 用户id
     * @param type   类型
     * @return
     */
    List<AccountFlow> querListAccountFlowInfo(Long userId,String type,Long rangeTime,Long statTime,Long endTime,Integer start, Integer length);


    Integer countFlowInfo(Long userId,String type,Long rangeTime,Long statTime,Long endTime);


}
