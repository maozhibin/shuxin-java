package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserMoneyChange {
    private Long id;

    private Long userId;

    private String payment;

    private BigDecimal balanceOld;

    private BigDecimal balanceNew;

    private BigDecimal amount;

    private Long dateline;

}