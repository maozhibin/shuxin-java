package com.baoquan.shuxin.model.stats;

public class StatsOrgProduct {
	 private Long id;

	 private Long orgId;

	 private Long productId;

	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	private Integer purchaseNum;

	 private Long dateline;
}
