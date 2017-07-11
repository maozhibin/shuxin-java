package com.baoquan.shuxin.util.product.api.huntian;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/5/4.
 */
public class SHA256 {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public String sign(TreeMap<String, String> params, String suffix) {
        StringBuilder str = new StringBuilder();
        //HashMap默认已经排好序
        for (String key : params.keySet()) {
            String value = params.get(key);
            str.append(value);
        }
        str.append(suffix);

        System.out.println(str.toString());
        //加密
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.toString().getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
