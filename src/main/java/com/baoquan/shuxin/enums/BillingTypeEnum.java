package com.baoquan.shuxin.enums;

/**
 * Desc:套餐类型 1:包次  2:包月
 * Created by yongj on 7/19/2017,
 */
public enum BillingTypeEnum {

    COUNT(0, "包次"),
    MONTH(1, "包月");

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    BillingTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
