package com.baoquan.shuxin.service.spi.product;

import java.util.List;


import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;

public interface ProductInterfaceParamService {
	
	void paramListInsert(List<ProductInterfaceParam> interfaceParamList);

	void deleteParamLit(Integer productId);

	Boolean setInterfaceParam(Integer productInterfaceId, Integer productId, JSONObject data);

	List<ProductInterfaceParam> paramslist(Integer idValue, String paramType);

}
