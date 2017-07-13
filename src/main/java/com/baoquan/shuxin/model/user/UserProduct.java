package com.baoquan.shuxin.model.user;

/**
 * Created by Administrator on 2017/6/8.
 */
public class UserProduct {
    private Long Id;

    private Long UserId;

    private Long ProductId;

    private Integer Status;

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

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
