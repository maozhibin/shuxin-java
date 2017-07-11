package com.baoquan.shuxin.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
public enum BillingMethodEnum {

    YEAR("y", "包年"),
    COUNT("t_normal", "按次");

    String code;
    String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    BillingMethodEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final static Map<String, BillingMethodEnum> codeMap = new HashMap<>();

    static {
        for (BillingMethodEnum billingMethodEnum : values()) {
            codeMap.put(billingMethodEnum.code, billingMethodEnum);
        }
    }

    public static BillingMethodEnum codeOf(String code) {
        return codeMap.get(code);
    }

    public static int compare(String code1, String code2) {
        BillingMethodEnum enum1 = codeMap.get(code1);
        BillingMethodEnum enum2 = codeMap.get(code2);
        if (enum1 == enum2) return 0;
        if (enum1 == null) return 1;
        if (enum2 == null) return -1;
        return enum1.ordinal() - enum2.ordinal();
    }
}
