package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductInterfaceCode implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer productId;

    private Integer productInterfaceId;

    private String code;

    private String name;

    private String desc;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}