package com.baoquan.shuxin.service.spi.user;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.User;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface UserService {

	Page<User> findListUser(String name, String mobile, String typeId, Page<User> page);

	Boolean deleteUser(Long id);

	User findByIdUserInfo(Long id);

}