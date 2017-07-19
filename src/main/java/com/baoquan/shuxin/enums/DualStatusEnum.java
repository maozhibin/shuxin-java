package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/19/2017,
 */
public enum DualStatusEnum {

    INEFFECTIVE(0, "无效"),
    EFFECTIVE(1, "有效");

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    DualStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
