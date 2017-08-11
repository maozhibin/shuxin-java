package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;


public class UserMoneyChange {
    private Long id;

    private Long userId;

    private String payment;

    private BigDecimal balanceOld;

    private BigDecimal balanceNew;

    private BigDecimal amount;

    private Long dateline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public BigDecimal getBalanceOld() {
        return balanceOld;
    }

    public void setBalanceOld(BigDecimal balanceOld) {
        this.balanceOld = balanceOld;
    }

    public BigDecimal getBalanceNew() {
        return balanceNew;
    }

    public void setBalanceNew(BigDecimal balanceNew) {
        this.balanceNew = balanceNew;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }
}