package com.baoquan.shuxin.service.spi.admin;

import java.util.List;

import com.baoquan.shuxin.model.admin.AdminUser;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
public interface AdminUserService {
    AdminUser queryByUserPass(String username, String password);

    int modifyPassword(Long userId, String oldPass, String newPass);

    int refreshLoginInfoById(Long id, String ip, Long timestamp);

    List<AdminUser> listUserByName(String name, Integer start, Integer length);

    Long countUserByName(String name);

    AdminUser queryById(Long id);

    boolean queryByUsername(String name);

    void addAdminUser(AdminUser adminUser);

	void addAdminUserInfo(String userName, String password, String copyPassword);
}
