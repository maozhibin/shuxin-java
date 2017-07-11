package com.baoquan.shuxin.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ProductBilling implements Serializable {
    private Long id;

    private Long productId;

    private String settlement;

    private String billingMethod;

    private Float price;

    private Long total;

    private Float overPrice;

    private Integer dateline;

    private Integer priority;

    private Integer validTime;

    private Integer expireTime;

    private Float discountRate;

    private Integer minUsed;

    public Integer getMinUsed() {
        return minUsed;
    }

    public void setMinUsed(Integer minUsed) {
        this.minUsed = minUsed;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Float getOverPrice() {
        return overPrice;
    }

    public void setOverPrice(Float overPrice) {
        this.overPrice = overPrice;
    }

    public Integer getDateline() {
        return dateline;
    }

    public void setDateline(Integer dateline) {
        this.dateline = dateline;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }
}
