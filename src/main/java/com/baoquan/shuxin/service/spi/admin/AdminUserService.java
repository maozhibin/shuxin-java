package com.baoquan.shuxin.service.spi.admin;

import com.baoquan.shuxin.model.admin.AdminUser;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
public interface AdminUserService {
    AdminUser queryUserPass(String username, String password);
    int modifyPassword(Long userId, String oldPass, String newPass);
}
