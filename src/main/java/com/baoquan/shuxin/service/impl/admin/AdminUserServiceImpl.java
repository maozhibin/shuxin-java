package com.baoquan.shuxin.service.impl.admin;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.admin.AdminUserDao;
import com.baoquan.shuxin.model.admin.AdminUser;
import com.baoquan.shuxin.service.spi.admin.AdminUserService;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
@Named
public class AdminUserServiceImpl implements AdminUserService {

    @Inject
    private AdminUserDao adminUserDao;

    public AdminUser queryUserPass(String username, String password) {
        return adminUserDao.queryUserPass(username, password);
    }

    @Override
    public int modifyPassword(Long userId, String oldPass, String newPass) {
        return adminUserDao.modifyPassword(userId, oldPass, newPass);
    }
}
