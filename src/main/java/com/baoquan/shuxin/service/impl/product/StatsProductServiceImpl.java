package com.baoquan.shuxin.service.impl.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.product.StatsProductDao;
import com.baoquan.shuxin.model.stats.StatsProduct;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
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

	@Override
	public List<StatsProduct> queryAllStatsProduct() {
		return statsProductDao.queryAllStatsProduct();
	}

	@Override
	public StatsProduct setStatsProductDaily(StatsProductDaily statsProductDaily) {
		Date now = new Date();
		StatsProduct statsProduct = new StatsProduct();
		statsProduct.setProductId(statsProductDaily.getProductId());
		statsProduct.setOrderNum(statsProductDaily.getOrderNum());
		statsProduct.setPurchaseNum(statsProductDaily.getPurchaseNum());
		statsProduct.setTotalAmount(statsProductDaily.getTotalAmount());
		statsProduct.setDateline(now.getTime());
		return statsProduct;
	}

	@Override
	public void insertStatsProductList(List<StatsProduct> insertStatsProductList) {
		statsProductDao.insertStatsProductList(insertStatsProductList);
	}

	@Override
	public StatsProduct queryProductId(Long productId) {
		return statsProductDao.queryProductId(productId);
	}

	@Override
	public void updateStatsProductList(List<StatsProduct> updateStatsProductList) {
		statsProductDao.updateStatsProductList(updateStatsProductList);
	}


}
