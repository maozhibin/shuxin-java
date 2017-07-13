package com.baoquan.shuxin.dao.user;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.UserMoneyLog;

public interface UserMoneyLogDao {

	Integer byIdFindUserMoneyLongTotal(Map<String, Object> map);

	List<UserMoneyLog> byIdFindUserMoneyLongList(Map<String, Object> map);

}
