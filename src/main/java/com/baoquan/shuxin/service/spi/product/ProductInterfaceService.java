package com.baoquan.shuxin.service.spi.product;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.ProductInterface;

public interface ProductInterfaceService {

	ProductInterface findByProductId(Integer id);

	Boolean setInterface(ProductInterface productInterface, JSONObject data,Integer productId);

}
