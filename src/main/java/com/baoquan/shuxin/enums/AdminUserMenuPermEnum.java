package com.baoquan.shuxin.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public enum AdminUserMenuPermEnum {

    READ(0b001, "读"),
    WRITE(0b010, "写"),
    MANAGE(0b100, "管理"),;

    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    AdminUserMenuPermEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static Map<Integer, AdminUserMenuPermEnum> permEnumMap = new HashMap<>(values().length);

    static {
        for (AdminUserMenuPermEnum adminUserMenuPermEnum : values()) {
            permEnumMap.put(adminUserMenuPermEnum.code, adminUserMenuPermEnum);
        }
    }

    static Map<Integer, String> permMap = new HashMap<>();

    private static void buildMap(AdminUserMenuPermEnum[] arr, int ordinal, int length, Set<Integer> perms) {
        for (int i = ordinal; i < length; i++) {
            perms.add(arr[i].code);
            //System.out.println(perms);
            addToMap(permEnumMap, perms, permMap);
            buildMap(arr, i + 1, length, perms);
            perms.remove(arr[i].code);
        }
    }

    private static void addToMap(Map<Integer, AdminUserMenuPermEnum> permEnumMap, Set<Integer> perms,
            Map<Integer, String> permMap) {
        Integer permCode = 0;
        String permDesc = "";
        for (Integer perm : perms) {
            permCode |= perm;
            permDesc += permEnumMap.get(perm).desc;
        }
        permMap.put(permCode, permDesc);
    }

    static {
        buildMap(values(), 0, values().length, Sets.<Integer>newTreeSet());
    }

    public static Map<Integer, AdminUserMenuPermEnum> getPermEnumMap() {
        return permEnumMap;
    }

    public static Map<Integer, String> getPermMap() {
        return permMap;
    }

    public static void main(String[] args) {
        System.out.println(permMap);
    }
}
