package com.baoquan.shuxin.dao.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.admin.AdminMenu;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
@Repository
public interface AdminMenuDao {
    AdminMenu queryById(Long id);

    List<AdminMenu> queryAllEffective();

    AdminMenu queryByUri(String uri);
}
