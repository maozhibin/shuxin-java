package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

/**
 * Desc:
 * Created by yongj on 7/13/2017,
 */
public class UserDiscount {
    private Long userId;
    private BigDecimal discount;
    private Long createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
