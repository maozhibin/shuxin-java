package com.baoquan.shuxin.service.spi.user;

import java.util.List;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.User;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface UserService {

	Page<User> findListUser(String name, String mobile, String typeId, Page<User> page);

	Boolean deleteUser(Long id);

	User findByIdUserInfo(Integer id);

	List<User> userList();

	void updateUser(User user);

	void addUser(User user);

	boolean isValidUserName(String orgName);

	boolean findByMobileUserIdfo(String mobile);
}
