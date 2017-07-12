package com.baoquan.shuxin.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baoquan.shuxin.model.user.User;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface UserDao {

	Integer findValidUser(Map<String, Object> parms);

	List<User> findUserInfo(Map<String, Object> parms);

	User findUserById(@Param("id") Long id);

	void deleteUser(Long id);

	User findByIdUserInfo(Long id);

}