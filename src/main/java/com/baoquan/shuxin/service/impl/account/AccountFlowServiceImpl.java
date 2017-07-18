package com.baoquan.shuxin.service.impl.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.account.AccountFlowDao;
import com.baoquan.shuxin.model.account.AccountFlow;
import com.baoquan.shuxin.service.spi.account.AccountFlowService;

/**
 * Author:
 * Description:${TODO}
 * DATA:10:18
 */
@Named
public class AccountFlowServiceImpl<T> implements AccountFlowService {

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
    public Page<AccountFlow> querListAccountFlowInfo(Long userId, String type, Long dateline, Long finishTime,
            Page<AccountFlow> page) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("userId",userId);
        parms.put("type",type);
        parms.put("page", page);
        List<AccountFlow> listInfo = accountFlowDao.querAccountFlowInfo(parms);
        Integer total = accountFlowDao.PageCount(parms);
        if (total != null) {
            page.setTotalRecordCount(total);
        }
        page.setResult(listInfo);
        return page;
    }
}
