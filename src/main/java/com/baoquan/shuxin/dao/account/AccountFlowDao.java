package com.baoquan.shuxin.dao.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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

    Integer pageCount(Map<String, Object> parms);

    AccountFlow querByIdAccountInfo(Long id);


    Integer countFlowInfo(@Param("userId") Long userId, @Param("type") String type,@Param("statTime") Long statTime,@Param("endTime") Long endTime);

}
