package com.baoquan.shuxin.service.spi.product;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.ProductDetail;

public interface ProductDetailService {

	ProductDetail findByProductId(Integer id);

	Boolean setDetail(JSONObject data, Integer productId);

}
