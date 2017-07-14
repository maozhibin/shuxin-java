package com.baoquan.shuxin.dao.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.admin.AdminUser;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
@Repository
public interface AdminUserDao {
    AdminUser queryUserPass(@Param("username") String username, @Param("password") String password);

    int modifyPassword(@Param("userId") Long userId, @Param("oldPass") String oldPass,
            @Param("newPass") String newPass);
}
