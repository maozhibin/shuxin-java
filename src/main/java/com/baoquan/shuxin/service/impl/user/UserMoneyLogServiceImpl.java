package com.baoquan.shuxin.service.impl.user;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.user.UserMoneyLogDao;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;

@Named
public class UserMoneyLogServiceImpl implements UserMoneyLogService {
	@Inject
	private UserMoneyLogDao userMoneyLogDao;

	@Override
	public Page<User> byIdFinduserMoneyChange(Page<User> page, Long endTimeValue, Long startTimeValue, Long id) {
		return null;
	}
}
