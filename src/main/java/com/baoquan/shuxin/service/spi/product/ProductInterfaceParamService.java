package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.baoquan.shuxin.model.product.ProductInterfaceParam;

public interface ProductInterfaceParamService {

	void paramListInsert(List<ProductInterfaceParam> interfaceParamList);

	void deleteParamLit(Integer productId);

}
