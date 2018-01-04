package com.baoquan.shuxin.model.admin;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
public class AdminUser {
    private Long id;
	private String username;// 账户
	private String password;// 密码
	private String lastIp;// 最近一次的IP地址
	private Long lastTime;// 最后一次登录时间
	private Integer status;// 0为账户不可用，1为可用
	private Long dateline;// 创建时间
	private Long angleId;

	public Long getAngleId() {
		return angleId;
	}

	public void setAngleId(Long angleId) {
		this.angleId = angleId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
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
