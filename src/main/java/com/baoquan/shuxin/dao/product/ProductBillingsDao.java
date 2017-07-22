package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductBillings;

@Repository
public interface ProductBillingsDao {

    List<ProductBillings> queryByType(@Param("productId") Long productId, @Param("type") Integer type);

	void delete(Integer productId);

	void insertList(List<ProductBillings> billingsList);

}