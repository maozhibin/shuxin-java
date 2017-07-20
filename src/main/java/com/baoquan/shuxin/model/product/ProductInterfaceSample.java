package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductInterfaceSample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer productId;

    private Integer productInterfaceId;

    private String type;

    private String value;

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

    public Integer getProductInterfaceId() {
        return productInterfaceId;
    }

    public void setProductInterfaceId(Integer productInterfaceId) {
        this.productInterfaceId = productInterfaceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}