package com.baoquan.shuxin.service.impl.product;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductDetailDao;
import com.baoquan.shuxin.model.product.ProductDetail;
import com.baoquan.shuxin.service.spi.product.ProductDetailService;
@Named
public class ProductDetailServiceImpl implements ProductDetailService{
	@Inject
	private ProductDetailDao productDetailDao;

	@Override
	public ProductDetail findByProductId(Integer id) {
		return productDetailDao.findByProductId(id);
	}
}
