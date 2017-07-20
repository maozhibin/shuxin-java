package com.baoquan.shuxin.enums;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:16:25 ${DATA}
 */
public enum OptionEnum {

    BILLING_METHOD(0,"billing_method"),
    NEWS_CLASS_TYPE(1,"news_class_type"),
    ACCOUNT_FLOW(2,"account_flow"),
    ORDER(3,"order");


    int code;
    String desc;

    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

    OptionEnum(int code,String desc){

        this.code = code;
        this.desc = desc;
    }

}
