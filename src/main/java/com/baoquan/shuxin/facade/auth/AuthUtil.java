package com.baoquan.shuxin.facade.auth;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.util.CryptUtil;

/**
 * Desc:
 * Created by yongj on 7/6/2017,
 */
public class AuthUtil {

    private final static ThreadLocal<Auth> holder = new ThreadLocal<>();

    public static void hold(Auth auth) {
        holder.set(auth);
    }

    public static Auth get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }

    public static Auth dec(String authStr) {
        authStr = CryptUtil.decAuth(authStr);
        return JSON.parseObject(authStr, Auth.class);
    }
}
