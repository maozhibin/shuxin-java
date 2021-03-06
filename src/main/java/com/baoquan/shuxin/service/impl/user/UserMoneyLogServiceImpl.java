package com.baoquan.shuxin.service.impl.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.user.UserMoneyLogDao;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.baoquan.shuxin.util.common.DateUtil;

@Named
public class UserMoneyLogServiceImpl implements UserMoneyLogService {
	@Inject
	private UserMoneyLogDao userMoneyLogDao;

	@Override
	public Page<UserMoneyLog> byIdFinduserMoneyChange(Page<UserMoneyLog> page, Long endTimeValue, Long startTimeValue,
			Long userId, String type) {
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
		if (!StringUtils.isEmpty(type)) {
			map.put("type", type);
		}
		map.put("page", page);
		Integer total = userMoneyLogDao.byIdFindUserMoneyLongTotal(map);
		page.setTotalRecordCount(total);
		List<UserMoneyLog> list = userMoneyLogDao.byIdFindUserMoneyLongList(map);
		page.setResult(list);
		return page;
	}

	@Override
	public Map<Object, Object> findByFinishTime(Long time) {
		String stampToDateY = DateUtil.stampToDateY(time.toString());
		List<Map<Object, Object>> list = userMoneyLogDao.findCountByFinishTime(stampToDateY);
		double[] arr= new double[24];
		Map<Object, Object> mapValue = new HashMap<>();
			for (Map<Object, Object> map : list) {
				Integer timeValue = MapUtils.getInteger(map, "timeValue");
				double count = MapUtils.getDouble(map, "count");
				arr[timeValue] = count;
			}
		mapValue.put(stampToDateY, arr);
		return mapValue;
	}

	@Override
	public Map<String, Object> queryAmountMoney() {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeToday = DateUtils.addDays(today, 0).getTime();//今天
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeToday= DateUtil.stampToDateY(timeToday.toString());
		String stampTimeYesterday= DateUtil.stampToDateY(timeYesterday.toString());
		Integer todaytAmount=userMoneyLogDao.findSumAmountByTime(stampTimeToday);
		Integer yesterdaytAmount=userMoneyLogDao.findSumAmountByTime(stampTimeYesterday);
		Map<String, Object> map = new HashMap<>();
		map.put("todaytAmount", todaytAmount);
		map.put("yesterdaytAmount", yesterdaytAmount);
		return map;
	}
}
