package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/19/2017,
 */
public enum DualEnum {

    NO(0, "不是"),
    YES(1, "是");

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    DualEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
