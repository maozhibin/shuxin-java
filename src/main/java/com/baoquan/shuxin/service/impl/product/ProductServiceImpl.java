package com.baoquan.shuxin.service.impl.product;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductDao;
import com.baoquan.shuxin.service.spi.product.ProductService;

@Named
public class ProductServiceImpl implements ProductService{
	@Inject
	private ProductDao productDao;
}
