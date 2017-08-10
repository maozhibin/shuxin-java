package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductBaseDao;
import com.baoquan.shuxin.model.product.ProductBase;
import com.baoquan.shuxin.service.spi.product.ProductBaseService;

@Named
public class ProductBaseServiceImpl implements ProductBaseService{
	@Inject
	private ProductBaseDao productBaseDao;

	@Override
	public List<ProductBase> findByProductClassId(Integer id) {
		return productBaseDao.findByProductClassId(id);
	}

	@Override
	public ProductBase queryById(Integer productBaseId) {
		return productBaseDao.queryById(productBaseId);
	}
}
