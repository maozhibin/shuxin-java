package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductInterfaceParam implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer productId;

    private Integer productInterfaceId;

    private String name;

    private String description;

    private Boolean must;

    private String type;

    private String paramType;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getMust() {
        return must;
    }

    public void setMust(Boolean must) {
        this.must = must;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }
}