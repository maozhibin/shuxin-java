package com.baoquan.shuxin.dao.admin;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
@Repository
public interface AdminUserMenuPermDao {

	List<AdminUserMenuPerm> listEffectiveByUser(@Param("angleIds") Collection<Long> angleIds);
	//
	// Long removeAllPermByUser(Long userId);
	//
	// int insertOrUpdate(AdminUserMenuPerm record);
	//
	AdminUserMenuPerm queryByUserMenuStatus(@Param("angleId") Long angleId, @Param("menuId") Long menuId,
			@Param("status") Integer status);
	//
	// void insertList(List<AdminUserMenuPerm> menuPermList);
}
