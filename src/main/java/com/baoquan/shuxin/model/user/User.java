package com.baoquan.shuxin.model.user;

/**
 * Created by Administrator on 2017/6/8.
 */
public class User {
	private Integer id;

	private String username;

	private Double moneyBalance;

	private Double moneyFreeze;

	private String mobile;

	private String email;

	private String password;

	private Integer lastLoginTime;

	private String lastLoginIp;

	private String typeId;

	private String realName;

	private String bankStatus;

	private String orgCode;

	private String payPassword;
	private Integer isValid;

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(Double moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public Double getMoneyFreeze() {
		return moneyFreeze;
	}

	public void setMoneyFreeze(Double moneyFreeze) {
		this.moneyFreeze = moneyFreeze;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastLoginTime(Integer lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setBankStatus(String bankStatus) {
		this.bankStatus = bankStatus;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getLastLoginTime() {
		return lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public String getTypeId() {
		return typeId;
	}

	public String getRealName() {
		return realName;
	}

	public String getBankStatus() {
		return bankStatus;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getPayPassword() {
		return payPassword;
	}
}
