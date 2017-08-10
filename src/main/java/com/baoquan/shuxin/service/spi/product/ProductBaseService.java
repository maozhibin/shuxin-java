package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.baoquan.shuxin.model.product.ProductBase;

public interface ProductBaseService {

	List<ProductBase> findByProductClassId(Integer id);

	ProductBase queryById(Integer productBaseId);

}
