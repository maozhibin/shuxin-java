package com.baoquan.shuxin.service.impl.product;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.StatsProductDao;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
@Named
public class StatsProductServiceImpl implements StatsProductService{
	@Inject
	private StatsProductDao statsProductDao;

	@Override
	public List<Map<String, Object>> productTop() {
		return statsProductDao.productTop();
	}

	@Override
	public List<Map<String, Object>> productList(Map<String, Object> map) {
		return statsProductDao.productList(map);
	}

	@Override
	public Long productListCount(Map<String, Object> map) {
		return statsProductDao.productListCount(map);
	}

}
