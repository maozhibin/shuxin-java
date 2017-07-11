package com.baoquan.shuxin.context;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
public class ContextInfo {

    private Long userId;
    private String className;
    private String methodName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
