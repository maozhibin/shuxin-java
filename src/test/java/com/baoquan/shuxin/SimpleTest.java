package com.baoquan.shuxin;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Desc:
 * Created by yongj on 7/19/2017,
 */
public class SimpleTest {

    public static void main(String[] args) {
        try {
            String secret = "administrator";
            String message = "aa123456";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(hash);
            System.out.println(hash.length());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
