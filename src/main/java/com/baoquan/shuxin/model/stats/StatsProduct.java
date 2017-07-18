package com.baoquan.shuxin.model.stats;

import java.math.BigDecimal;

public class StatsProduct {
	 private Long productId;

	 private BigDecimal totalAmount;

	 private Long orderNum;

	 private Long purchaseNum;

	 private Long dateline;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Long getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(Long purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

}
