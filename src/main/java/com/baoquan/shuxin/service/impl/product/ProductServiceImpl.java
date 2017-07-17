package com.baoquan.shuxin.service.impl.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.product.ProductDao;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.service.spi.product.ProductService;

@Named
public class ProductServiceImpl implements ProductService{
	@Inject
	private ProductDao productDao;

	@Override
	public Page<Map<String,Object>> findListProduct(Page<Map<String, Object>> page, String name) {
		Map<String,Object>  map= new HashMap<>();
		map.put("name",name);
		map.put("page",page);
		Integer total = productDao.countByName(map);
		List<Map<String,Object> > list = productDao.productList(map);
		page.setTotalRecordCount(total);
		page.setResult(list);
		return page;
	}
}
