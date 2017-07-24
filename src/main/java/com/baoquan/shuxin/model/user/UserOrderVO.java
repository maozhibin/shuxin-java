package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:11 ${DATA}
 */
public class UserOrderVO {

    private Integer userId;
    private String name;
    private BigDecimal buyAmount;
    private BigDecimal payAmount;
    private String statuName;
    private String requestNo;
    private Integer buyTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getStatuName() {
        return statuName;
    }

    public void setStatuName(String statuName) {
        this.statuName = statuName;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Integer getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Integer buyTime) {
        this.buyTime = buyTime;
    }
}
