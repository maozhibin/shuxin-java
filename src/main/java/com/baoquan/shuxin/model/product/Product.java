package com.baoquan.shuxin.model.product;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -3993874942780998213L;

    private Long id;
    private String reflectClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReflectClass() {
        return reflectClass;
    }

    public void setReflectClass(String reflectClass) {
        this.reflectClass = reflectClass;
    }
}
