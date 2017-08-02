package com.baoquan.shuxin.model.stats;

import java.math.BigDecimal;
import java.util.Date;

public class StatsOrgDaily {
    private Long id;

    private Long orgId;

    private BigDecimal totalAmount;

    private Long orderNum;

    private Long receiptNum;

    private Date statsDate;

    private Long dateline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(Long receiptNum) {
        this.receiptNum = receiptNum;
    }

    public Date getStatsDate() {
        return statsDate;
    }

    public void setStatsDate(Date statsDate) {
        this.statsDate = statsDate;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }
}