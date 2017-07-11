package com.baoquan.shuxin.model;

/**
 * Created by Administrator on 2017/6/8.
 */
public class User {
    private Long id;

    private Float MoneyBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMoneyBalance() {
        return MoneyBalance;
    }

    public void setMoneyBalance(Float moneyBalance) {
        MoneyBalance = moneyBalance;
    }
}
