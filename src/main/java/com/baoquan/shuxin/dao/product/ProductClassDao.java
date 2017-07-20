package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductClass;

@Repository
public interface ProductClassDao {

	List<ProductClass> findAllClassList();
   
}