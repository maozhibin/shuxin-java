package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductInterfaceParam;

@Repository
public interface ProductInterfaceParamDao {

	void paramListInsert(List<ProductInterfaceParam> interfaceParamList);

	void deleteParamLit(Integer productId);
   
}