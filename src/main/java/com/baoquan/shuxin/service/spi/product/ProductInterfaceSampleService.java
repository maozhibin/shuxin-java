package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.baoquan.shuxin.model.product.ProductInterfaceSample;

public interface ProductInterfaceSampleService {

	List<ProductInterfaceSample> findByProductId(Integer id);

}
