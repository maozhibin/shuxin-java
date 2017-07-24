package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductInterfaceCodeDao;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceCodeService;

@Named
public class ProductInterfaceCodeServiceImpl  implements ProductInterfaceCodeService{
	@Inject
	private ProductInterfaceCodeDao productInterfaceCodeDao;

	@Override
	public List<ProductInterfaceCode> interfaceCodeList(Integer id) {
		return productInterfaceCodeDao.interfaceCodeList(id);
	}

}
