package com.baoquan.shuxin.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.ProductBilling;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
@Repository
public interface ProductBillingDao {
    List<ProductBilling> queryByIds(@Param("ids") Collection<Long> ids);
}
