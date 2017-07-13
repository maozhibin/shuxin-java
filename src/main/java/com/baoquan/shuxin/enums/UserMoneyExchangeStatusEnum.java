package com.baoquan.shuxin.enums;

/**
 * Desc: 0 未完成 1 已完成 2 已取消 3 已失败
 * Created by yongj on 7/12/2017,
 */
public enum UserMoneyExchangeStatusEnum {

    UNCOMPLETED(0, "未完成"),
    SUCCEED(1, "已完成"),
    CANCELED(2, "已取消"),
    FAILED(2, "已失败"),
    ;

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    UserMoneyExchangeStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
