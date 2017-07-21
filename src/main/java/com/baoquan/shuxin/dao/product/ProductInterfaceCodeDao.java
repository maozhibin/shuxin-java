package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductInterfaceCode;

@Repository
public interface ProductInterfaceCodeDao {

	void delete(Integer productId);

	void insertList(List<ProductInterfaceCode> codeList);
    
}