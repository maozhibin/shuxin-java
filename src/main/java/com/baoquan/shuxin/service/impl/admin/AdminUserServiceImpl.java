package com.baoquan.shuxin.service.impl.admin;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.admin.AdminUserDao;
import com.baoquan.shuxin.dao.admin.AdminUserMenuPermDao;
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
    @Inject
    private AdminUserMenuPermDao adminUserMenuPermDao;
    
    @Override
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

    @Override
    public boolean queryByUsername(String name) {
        if(adminUserDao.queryByUsername(name)!=null){
            return  false;
        }
        return true;
    }

    @Override
    public void addAdminUser(AdminUser adminUser) {
        adminUserDao.addAdminUser(adminUser);
    }

	// @Override
	// public void addAdminUserInfo(String userName, String password, String
	// copyPassword) {
	// AdminUser adminUser = new AdminUser();
	// adminUser.setUsername(userName);
	// Mac sha256_HMAC;
	// try {
	// sha256_HMAC = Mac.getInstance("HmacSHA256");
	// SecretKeySpec secret_key = new SecretKeySpec(userName.getBytes(),
	// "HmacSHA256");
	// sha256_HMAC.init(secret_key);
	// String hash =
	// Base64.encodeBase64String(sha256_HMAC.doFinal(password.getBytes()));
	// adminUser.setPassword(hash);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// adminUser.setStatus(1);
	// Date date = new Date();
	// adminUser.setDateline(date.getTime());
	// addAdminUser(adminUser);
	// //默认设置控制台查看权限
	// List<AdminUserMenuPerm> menuPermList = new ArrayList<>();
	// AdminUser queryByUsername = adminUserDao.queryByUsername(userName);
	// Long id = queryByUsername.getId();
	// for(int i = 1; i < 5; i++){
	// AdminUserMenuPerm menuPerm = new AdminUserMenuPerm();
	// menuPerm.setUserId(id);
	// menuPerm.setDateline(new Date().getTime());
	// menuPerm.setMenuId((long) i);
	// menuPerm.setPerm(1);
	// menuPerm.setStatus(1);
	// menuPermList.add(menuPerm);
	// }
	// adminUserMenuPermDao.insertList(menuPermList);
	// }
}
