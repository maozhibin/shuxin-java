package com.baoquan.shuxin.model.admin;

public class AdminUserMenuPerm {
    private Long id;

    private Long userId;

    private Long menuId;

    private Integer perm;

    private Integer status;

    private Long dateline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getPerm() {
        return perm;
    }

    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }
}