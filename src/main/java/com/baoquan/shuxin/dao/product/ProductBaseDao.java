package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductBase;

@Repository
public interface ProductBaseDao {

	List<ProductBase> findByProductClassId(Integer id);
   
}