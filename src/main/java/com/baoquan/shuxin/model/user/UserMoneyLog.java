package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

import lombok.Data;

public class UserMoneyLog {

	private Long id;

	private String type;

	private Long userId;

	private BigDecimal amount;

	private String remark;

	private String itemInfo;

	private Integer status;

	private String requestNo;

	private Long dateline;

	private Integer reverse;

	private Long reverseTime;

	private BigDecimal fee;

	private String expense;

	private String userRemark;

	private String feeRelative;

	private BigDecimal extraCost;

	private String extraExpense;

	private String extraRequest;

	private String statusDesc;

	private Long finishTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public Integer getReverse() {
		return reverse;
	}

	public void setReverse(Integer reverse) {
		this.reverse = reverse;
	}

	public Long getReverseTime() {
		return reverseTime;
	}

	public void setReverseTime(Long reverseTime) {
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

	public Long getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}
}
