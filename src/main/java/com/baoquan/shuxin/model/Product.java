package com.baoquan.shuxin.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -3993874942780998213L;

    private Long id;
    private String reflectClass;

}
