package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductInterfaceSample;

@Repository
public interface ProductInterfaceSampleDao {

	void insertSample(List<ProductInterfaceSample> sampleList);

	void delete(Integer productId);
   
}