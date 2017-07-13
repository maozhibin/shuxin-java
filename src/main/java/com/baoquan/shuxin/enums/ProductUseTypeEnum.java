package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/13/2017,
 */
public enum  ProductUseTypeEnum {

    Normal(0, "普通调用"),
    Online(1, "在线查询");

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ProductUseTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
