package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductTag;

@Repository
public interface ProductTagDao {
	List<ProductTag> findByproductId(Integer productId);
}