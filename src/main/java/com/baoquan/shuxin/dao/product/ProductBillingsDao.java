package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductBillings;

@Repository
public interface ProductBillingsDao {

	void delete(Integer productId);

	void insertList(List<ProductBillings> billingsList);
   
}