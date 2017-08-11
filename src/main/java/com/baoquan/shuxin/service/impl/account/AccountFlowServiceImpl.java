package com.baoquan.shuxin.service.impl.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;
import javax.inject.Named;


import com.baoquan.shuxin.dao.account.AccountFlowDao;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.service.spi.account.AccountFlowService;

/**
 * Author:
 * Description:${TODO}
 * DATA:10:18
 */
@Named
public class AccountFlowServiceImpl implements AccountFlowService {

    @Inject
    private AccountFlowDao accountFlowDao;
    @Override
    public AccountFlow querListByIdAccountFlow(Long id) {
        if (id==null){
            return null;
        }
        return accountFlowDao.querByIdAccountInfo(id);
    }

    @Override
    public List<AccountFlow> querListAccountFlowInfo(Long userId, String type, Long statTime,Long endTime,Integer start, Integer length) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("userId",userId);
        parms.put("type",type);
        parms.put("statTime",statTime);
        parms.put("endTime",endTime);
        parms.put("start",start);
        parms.put("length",length);
        return accountFlowDao.querAccountFlowInfo(parms);
    }

    @Override
    public Integer countFlowInfo(Long userId, String type ,Long statTime, Long endTime) {
        return accountFlowDao.countFlowInfo(userId,type,statTime,endTime);
    }
}
