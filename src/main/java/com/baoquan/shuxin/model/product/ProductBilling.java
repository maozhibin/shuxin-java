package com.baoquan.shuxin.model.product;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/6.
 */
@Data
public class ProductBilling implements Serializable {
    private Long id;

    private Long productId;

    private String settlement;

    private String billingMethod;

    private BigDecimal price;

    private Long total;

    private BigDecimal overPrice;

    private Long dateline;

    private Integer priority;

    private Long validTime;

    private Long expireTime;

    private BigDecimal discountRate;

    private Integer minUsed;

}
