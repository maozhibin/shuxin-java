package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductInterfaceSampleDao;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceSampleService;

@Named
public class ProductInterfaceSampleServiceImpl implements ProductInterfaceSampleService{
	@Inject
	private ProductInterfaceSampleDao productInterfaceSampleDao;

	@Override
	public List<ProductInterfaceSample> findByProductId(Integer id) {
		
		return productInterfaceSampleDao.findByProductId(id);
	}
}
