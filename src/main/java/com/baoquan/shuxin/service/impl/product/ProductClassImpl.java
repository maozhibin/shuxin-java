package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baoquan.shuxin.dao.product.ProductClassDao;
import com.baoquan.shuxin.model.product.ProductClass;
import com.baoquan.shuxin.service.spi.product.ProductClassService;
@Named
public class ProductClassImpl implements ProductClassService{
	@Autowired
	private ProductClassDao productClassDao;

	@Override
	public List<ProductClass> findAllClassList() {
		return productClassDao.findAllClassList();
	}

	@Override
	public ProductClass queryById(Integer productClassId) {
		return productClassDao.queryById(productClassId);
	}
}
