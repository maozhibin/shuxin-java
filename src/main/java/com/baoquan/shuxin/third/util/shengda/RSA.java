package com.baoquan.shuxin.third.util.shengda;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 使用{@code RAS} 方式加签和验签
 * @author sunaolin
 */
public class RSA {

    public static final String SIGN_ALGORITHMS = "MD5withRSA";

    public static String sign(String content, String privateKey, String charset) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(keySpec);
            return sign(content, priKey, charset);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String sign(String content, PrivateKey privateKey,
            String charset) {
        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(privateKey);
            signature.update(content.getBytes(charset));

            return Base64.encode(signature.sign());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean verify(String content, String sign, String publicKey,
            String charset) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(
                    Base64.decode(publicKey));

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            return verify(content, sign, pubKey, charset);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean verify(String content, String sign,
            PublicKey publicKey, String charset) {
        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(publicKey);
            signature.update(content.getBytes(charset));

            return signature.verify(Base64.decode(sign));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
