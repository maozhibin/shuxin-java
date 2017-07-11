package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
public enum FreeEnum {

    YES(0, "免费"),
    NO(1, "收费");

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    FreeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
