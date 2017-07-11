package com.baoquan.shuxin.model;

/**
 * Created by Administrator on 2017/6/8.
 */
public class UserProductUse {
    private Long id;

    private Long userProductId;

    private Long productBillingId;

    private Integer start;

    private Integer end;

    private Integer total;

    private Integer used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(Long userProductId) {
        this.userProductId = userProductId;
    }

    public Long getProductBillingId() {
        return productBillingId;
    }

    public void setProductBillingId(Long productBillingId) {
        this.productBillingId = productBillingId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
