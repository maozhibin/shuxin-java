package com.baoquan.shuxin.service.spi.user;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.UserMoneyLog;

public interface UserMoneyLogService {

	Page<UserMoneyLog> byIdFinduserMoneyChange(Page<UserMoneyLog> page, Long endTimeValue, Long startTimeValue,
			Long userId, String type);

	Map<Object, Object> findByFinishTime(Long time);

}
