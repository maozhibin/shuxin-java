package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;

public interface ProductInterfaceCodeService {

	List<ProductInterfaceCode> interfaceCodeList(Integer idValue);

	Boolean setCode(Integer productId, Integer productInterfaceId, JSONObject data);

}
