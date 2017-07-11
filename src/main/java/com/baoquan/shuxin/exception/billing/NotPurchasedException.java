package com.baoquan.shuxin.exception.billing;

import org.jetbrains.annotations.NonNls;

/**
 * Created by Administrator on 2017/6/8.
 */
public class NotPurchasedException extends RuntimeException {
    public NotPurchasedException() {
    }

    public NotPurchasedException(@NonNls String message) {
        super(message);
    }

    public NotPurchasedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPurchasedException(Throwable cause) {
        super(cause);
    }

    public NotPurchasedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
