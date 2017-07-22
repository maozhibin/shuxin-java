package com.baoquan.shuxin.model.user;

public class UserProductUsage {
    private Long id;

    private Long userId;

    private Long productId;

    private Long timeStart;

    private Long timeEnd;

    private Long timeUsed;

    private Long countRemain;

    private Long countUsed;

    private Long extra;

    private String appCode;

    private String appSecret;

    private String appKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Long timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Long getCountRemain() {
        return countRemain;
    }

    public void setCountRemain(Long countRemain) {
        this.countRemain = countRemain;
    }

    public Long getCountUsed() {
        return countUsed;
    }

    public void setCountUsed(Long countUsed) {
        this.countUsed = countUsed;
    }

    public Long getExtra() {
        return extra;
    }

    public void setExtra(Long extra) {
        this.extra = extra;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}