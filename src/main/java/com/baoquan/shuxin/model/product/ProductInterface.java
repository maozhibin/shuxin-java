package com.baoquan.shuxin.model.product;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
public class ProductInterface implements Serializable {
    private static final long serialVersionUID = -5948878756640864787L;

    private Long id;
    private Long productId;
    private Integer free;
    private String reflectMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public String getReflectMethod() {
        return reflectMethod;
    }

    public void setReflectMethod(String reflectMethod) {
        this.reflectMethod = reflectMethod;
    }
}
