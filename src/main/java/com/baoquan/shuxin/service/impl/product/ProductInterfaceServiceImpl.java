package com.baoquan.shuxin.service.impl.product;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductInterfaceDao;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceService;

@Named
public class ProductInterfaceServiceImpl implements ProductInterfaceService{
	@Inject
	private ProductInterfaceDao productInterfaceDao;
	@Override
	public ProductInterface findByProductId(Integer id) {
		return productInterfaceDao.findByProductId(id);
	}

}
