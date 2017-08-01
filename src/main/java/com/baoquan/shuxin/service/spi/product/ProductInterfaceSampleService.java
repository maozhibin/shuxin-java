package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;

public interface ProductInterfaceSampleService {

	List<ProductInterfaceSample> findByProductId(Integer id);

	Boolean setSample(JSONObject data, Integer productId, Integer productInterfaceId);

}
