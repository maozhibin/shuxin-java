package com.baoquan.shuxin.dao.account;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.account.AccountFlow;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:9:27 ${DATA}
 */
@Repository
public interface AccountFlowDao {

    /**
     * 查询账户
     * @param parm
     * @return
     */
    List<AccountFlow> querAccountFlowInfo(Map<String, Object> parm);

    Integer PageCount(Map<String, Object> parms);

    AccountFlow querByIdAccountInfo(Long id);

}
