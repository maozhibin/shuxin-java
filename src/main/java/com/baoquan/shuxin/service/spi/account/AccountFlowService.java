package com.baoquan.shuxin.service.spi.account;

import java.math.BigDecimal;

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
     * @param dateline   生成时间
     * @param finishTime 结束时间
     * @param page
     * @return
     */
    Page<AccountFlow> querListAccountFlowInfo(Long userId,String type,Long dateline,Long finishTime,Page<AccountFlow> page);
}
