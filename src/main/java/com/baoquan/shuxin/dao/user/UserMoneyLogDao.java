package com.baoquan.shuxin.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserMoneyLog;

@Repository
public interface UserMoneyLogDao {

    Integer byIdFindUserMoneyLongTotal(Map<String, Object> map);

    List<UserMoneyLog> byIdFindUserMoneyLongList(Map<String, Object> map);

    int insertSelective(UserMoneyLog record);

	List<Map<Object, Object>> findByFinishTime(String stampToDateY);

}
