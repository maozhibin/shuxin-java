package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductInterfaceParamDao;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;

@Named
public class ProductInterfaceParamServiceImpl implements ProductInterfaceParamService{
	@Inject
	private ProductInterfaceParamDao productInterfaceParamDao;

	@Override
	public void paramListInsert(List<ProductInterfaceParam> interfaceParamList) {
		productInterfaceParamDao.paramListInsert(interfaceParamList);
	}

	@Override
	public void deleteParamLit(Integer productId) {
		productInterfaceParamDao.deleteParamLit(productId);
		
	}

}
