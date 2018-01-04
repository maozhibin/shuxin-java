package com.baoquan.shuxin.service.spi.admin;

import java.util.Collection;
import java.util.List;

import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public interface AdminUserMenuPermService {

	List<AdminUserMenuPerm> listEffectiveByUser(Collection<Long> angleIds);
	//
	// void resetUserMenuPerm(Long userId, Long[] menuIds);
	//
	// Long removeAllPermByUser(Long userId);
	//
	// int insertOrUpdate(AdminUserMenuPerm record);
	//
	AdminUserMenuPerm queryByUserMenuStatus(Long angleId, Long menuId, Integer status);
}
