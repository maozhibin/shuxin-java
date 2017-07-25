package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.baoquan.shuxin.model.product.ProductBillings;

public interface ProductBillingsService {

	List<ProductBillings> findByProductId(Integer id);

}
