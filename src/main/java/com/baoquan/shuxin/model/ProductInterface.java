package com.baoquan.shuxin.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
@Data
public class ProductInterface implements Serializable {
    private static final long serialVersionUID = -5948878756640864787L;

    private Long id;
    private Long productId;
    private Integer free;
    private String reflectMethod;
}
