package com.baoquan.shuxin.web.vo;

import java.math.BigDecimal;

/**
 * Desc:
 * Created by yongj on 7/24/2017,
 */
public class PlatformOverviewVO {

    private BigDecimal tradeAmount = BigDecimal.ZERO;
    private long orderCount;
    private long attestCount;
    private BigDecimal tradeIncreaseRate = BigDecimal.valueOf(100);
    private long authorizationCount;

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }

    public long getAttestCount() {
        return attestCount;
    }

    public void setAttestCount(long attestCount) {
        this.attestCount = attestCount;
    }

    public BigDecimal getTradeIncreaseRate() {
        return tradeIncreaseRate;
    }

    public void setTradeIncreaseRate(BigDecimal tradeIncreaseRate) {
        this.tradeIncreaseRate = tradeIncreaseRate;
    }

    public long getAuthorizationCount() {
        return authorizationCount;
    }

    public void setAuthorizationCount(long authorizationCount) {
        this.authorizationCount = authorizationCount;
    }
}
