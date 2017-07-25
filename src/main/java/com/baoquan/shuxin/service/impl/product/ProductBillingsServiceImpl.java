package com.baoquan.shuxin.service.impl.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.ProductBillingsDao;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.service.spi.product.ProductBillingsService;
@Named
public class ProductBillingsServiceImpl implements ProductBillingsService{
	@Inject
	private ProductBillingsDao productBillingsDao;

	@Override
	public List<ProductBillings> findByProductId(Integer id) {
		return productBillingsDao.findByProductId(id);
	}
}
