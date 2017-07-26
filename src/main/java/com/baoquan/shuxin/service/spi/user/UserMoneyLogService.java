package com.baoquan.shuxin.service.spi.user;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.UserMoneyLog;

public interface UserMoneyLogService {

	Page<UserMoneyLog> byIdFinduserMoneyChange(Page<UserMoneyLog> page, Long endTimeValue, Long startTimeValue,
			Long userId, String type);

}
