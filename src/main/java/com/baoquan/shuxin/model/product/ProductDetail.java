package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer productId;
    
    private String intro;

    private String snapshot;

    private String highlight;

    private String service;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
    
   
}