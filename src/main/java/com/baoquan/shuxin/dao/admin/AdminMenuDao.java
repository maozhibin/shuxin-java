package com.baoquan.shuxin.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

    List<AdminMenu> query(@Param("status") Integer status, @Param("isdir") Integer isdir,
            @Param("display") Integer display);
}
