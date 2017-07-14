package com.baoquan.shuxin.enums;

/**
 * Desc:
 * Created by yongj on 7/14/2017,
 */
public enum UserTypeEnum {

    USER("USER", "个人"),
    ORG("ORG", "机构"),
    ;

    String code;
    String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
