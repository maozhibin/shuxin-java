package com.baoquan.shuxin.model;

/**
 * Created by Administrator on 2017/6/8.
 */
public class UserProduct {
    private Long Id;

    private Long UserId;

    private Long ProductId;

    private Short Status;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public Short getStatus() {
        return Status;
    }

    public void setStatus(Short status) {
        Status = status;
    }
}
