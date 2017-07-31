package com.baoquan.shuxin.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.admin.AdminMenu;
import com.baoquan.shuxin.model.admin.AdminUser;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
@Repository
public interface AdminUserDao {
    AdminUser queryByUserPass(@Param("username") String username, @Param("password") String password);

    int modifyPassword(@Param("userId") Long userId, @Param("oldPass") String oldPass,
            @Param("newPass") String newPass);

    int refreshLoginInfoById(@Param("id") Long id, @Param("ip") String ip, @Param("timestamp") Long timestamp);

    List<AdminUser> listUserByName(@Param("name") String name, @Param("start") Integer start,
            @Param("length") Integer length);

    Long countUserByName(@Param("name") String name);

    AdminUser queryById(Long id);

    AdminUser queryByUsername(String name);

    void addAdminUser(AdminUser adminUser);
}
