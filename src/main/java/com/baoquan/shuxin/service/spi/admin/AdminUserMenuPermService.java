package com.baoquan.shuxin.service.spi.admin;

import java.util.Collection;
import java.util.List;

import com.baoquan.shuxin.model.admin.AdminUserMenuPerm;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public interface AdminUserMenuPermService {
    List<AdminUserMenuPerm> listEffectiveByUser(Collection<Long> userIds);

    void resetUserMenuPerm(Long userId, Long[] menuIds);

    Long removeAllPermByUser(Long userId);

    int insertOrUpdate(AdminUserMenuPerm record);

    AdminUserMenuPerm queryByUserMenuStatus(Long userId, Long menuId, Integer status);
}
