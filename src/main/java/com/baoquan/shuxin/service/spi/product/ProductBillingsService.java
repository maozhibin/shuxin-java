package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductBillings;

public interface ProductBillingsService {

	List<ProductBillings> findByProductId(Integer id);

	Boolean setBillings(JSONObject data, Integer productId, Product product, Integer time);

}
