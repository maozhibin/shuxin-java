package com.baoquan.shuxin.context;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
public class AppContext {

    private static ThreadLocal<ContextInfo> contextInfo = new ThreadLocal<>();

    public static ContextInfo get() {
        return contextInfo.get();
    }

    public static void set(ContextInfo value) {
        contextInfo.set(value);
    }

    public static void remove() {
        contextInfo.remove();
    }
}
