package com.baoquan.shuxin.context;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
public class ContextInfo {

    private Long userId;
    private Long productId;
    private Integer type;//0普通调用，1在线查询

    private String className;
    private String methodName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
