package com.baoquan.shuxin.service.impl.admin;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.admin.AdminUserMenuPermDao;
import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;
import com.baoquan.shuxin.service.spi.admin.AdminUserMenuPermService;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
@Named
public class AdminUserMenuPermServiceImpl implements AdminUserMenuPermService {

    @Inject
    private AdminUserMenuPermDao adminUserMenuPermDao;

	@Override
	public List<AdminUserMenuPerm> listEffectiveByUser(Collection<Long> angleIds) {
		return adminUserMenuPermDao.listEffectiveByUser(angleIds);
	}
	//
	// @Transactional
	// @Override
	// public void resetUserMenuPerm(Long userId, Long[] menuIds) {
	// removeAllPermByUser(userId);
	// if (menuIds != null) {
	// for (Long menuId : menuIds) {
	// AdminUserMenuPerm record = new AdminUserMenuPerm();
	// record.setUserId(userId);
	// record.setMenuId(menuId);
	// record.setPerm(DualStatusEnum.EFFECTIVE.getCode());
	// record.setStatus(DualStatusEnum.EFFECTIVE.getCode());
	// record.setDateline(System.currentTimeMillis());
	// insertOrUpdate(record);
	// }
	// }
	// }
	//
	// @Override
	// public Long removeAllPermByUser(Long userId) {
	// return adminUserMenuPermDao.removeAllPermByUser(userId);
	// }
	//
	// @Override
	// public int insertOrUpdate(AdminUserMenuPerm record) {
	// return adminUserMenuPermDao.insertOrUpdate(record);
	// }
	//
	@Override
	public AdminUserMenuPerm queryByUserMenuStatus(Long angleId, Long menuId, Integer status) {
		return adminUserMenuPermDao.queryByUserMenuStatus(angleId, menuId, status);
	}
}