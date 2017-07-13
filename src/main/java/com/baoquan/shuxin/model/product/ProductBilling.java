package com.baoquan.shuxin.model.product;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/6.
 */
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

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public BigDecimal getOverPrice() {
        return overPrice;
    }

    public void setOverPrice(BigDecimal overPrice) {
        this.overPrice = overPrice;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getValidTime() {
        return validTime;
    }

    public void setValidTime(Long validTime) {
        this.validTime = validTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getMinUsed() {
        return minUsed;
    }

    public void setMinUsed(Integer minUsed) {
        this.minUsed = minUsed;
    }
}
