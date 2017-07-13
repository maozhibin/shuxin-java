package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/12/2017,
 */
public enum UserMoneyExchangeTypeEnum {

    CONSUME("consume", "消费"),
    RECHARGE("recharge", "充值"),
    BUY_PRODUCT("buy_product", "购买"),
    ;

    String code;
    String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    UserMoneyExchangeTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
