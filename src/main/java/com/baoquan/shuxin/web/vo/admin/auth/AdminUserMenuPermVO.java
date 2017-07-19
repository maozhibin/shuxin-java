package com.baoquan.shuxin.web.vo.admin.auth;

import java.util.Date;
import java.util.Map;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public class AdminUserMenuPermVO {

    private Long userId;
    private String username;
    private Date lastLoginTime;
    private Map<Long, Integer> menuPerm;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Map<Long, Integer> getMenuPerm() {
        return menuPerm;
    }

    public void setMenuPerm(Map<Long, Integer> menuPerm) {
        this.menuPerm = menuPerm;
    }
}
