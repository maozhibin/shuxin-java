package com.baoquan.shuxin.service.impl.admin;

import java.util.List;

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

    public AdminUser queryByUserPass(String username, String password) {
        return adminUserDao.queryByUserPass(username, password);
    }

    @Override
    public int modifyPassword(Long userId, String oldPass, String newPass) {
        return adminUserDao.modifyPassword(userId, oldPass, newPass);
    }

    @Override
    public int refreshLoginInfoById(Long id, String ip, Long timestamp) {
        return adminUserDao.refreshLoginInfoById(id, ip, timestamp);
    }

    @Override
    public List<AdminUser> listUserByName(String name, Integer start, Integer length) {
        return adminUserDao.listUserByName(name, start, length);
    }

    @Override
    public Long countUserByName(String name) {
        return adminUserDao.countUserByName(name);
    }

    @Override
    public AdminUser queryById(Long id) {
        return adminUserDao.queryById(id);
    }
}
