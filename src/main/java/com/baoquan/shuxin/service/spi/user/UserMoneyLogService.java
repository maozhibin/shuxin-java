package com.baoquan.shuxin.service.spi.user;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.User;

public interface UserMoneyLogService {

	Page<User> byIdFinduserMoneyChange(Page<User> page, Long endTimeValue, Long startTimeValue, Long id);

}
