package com.baoquan.shuxin.model;

import java.math.BigDecimal;

public class UserMoneyLog {
	private Integer id;

	private String type;

	private Integer userId;

	private BigDecimal amount;

	private String remark;

	private String itemInfo;

	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public Integer getDateline() {
		return dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public Boolean getReverse() {
		return reverse;
	}

	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}

	public Integer getReverseTime() {
		return reverseTime;
	}

	public void setReverseTime(Integer reverseTime) {
		this.reverseTime = reverseTime;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getFeeRelative() {
		return feeRelative;
	}

	public void setFeeRelative(String feeRelative) {
		this.feeRelative = feeRelative;
	}

	public BigDecimal getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(BigDecimal extraCost) {
		this.extraCost = extraCost;
	}

	public String getExtraExpense() {
		return extraExpense;
	}

	public void setExtraExpense(String extraExpense) {
		this.extraExpense = extraExpense;
	}

	public String getExtraRequest() {
		return extraRequest;
	}

	public void setExtraRequest(String extraRequest) {
		this.extraRequest = extraRequest;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Integer getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Integer finishTime) {
		this.finishTime = finishTime;
	}

	private String requestNo;

	private Integer dateline;

	private Boolean reverse;

	private Integer reverseTime;

	private BigDecimal fee;

	private String expense;

	private String userRemark;

	private String feeRelative;

	private BigDecimal extraCost;

	private String extraExpense;

	private String extraRequest;

	private String statusDesc;

	private Integer finishTime;
}
