package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductTag implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Integer productId;

    private Integer tagId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}