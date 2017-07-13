package com.baoquan.shuxin.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.user.UserMoneyLogDao;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;

@Named
public class UserMoneyLogServiceImpl implements UserMoneyLogService {
	@Inject
	private UserMoneyLogDao userMoneyLogDao;

	@Override
	public Page<UserMoneyLog> byIdFinduserMoneyChange(Page<UserMoneyLog> page, Long endTimeValue, Long startTimeValue,
			Long userId) {
		Map<String, Object> map = new HashMap<>();
		if (userId == null) {
			return null;
		}
		map.put("userId", userId);
		if (endTimeValue != null) {
			map.put("endTimeValue", endTimeValue);
		}
		if (startTimeValue != null) {
			map.put("startTimeValue", startTimeValue);
		}
		map.put("page", page);
		Integer total = userMoneyLogDao.byIdFindUserMoneyLongTotal(map);
		page.setTotalRecordCount(total);
		List<UserMoneyLog> list = userMoneyLogDao.byIdFindUserMoneyLongList(map);
		page.setResult(list);
		return page;
	}
}
