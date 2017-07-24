package com.baoquan.shuxin.dao.product;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductDetail;

@Repository
public interface ProductDetailDao {

	void delete(Integer productId);

	void insert(ProductDetail productDetail);

	ProductDetail findByProductId(Integer id);
   
}