package com.baoquan.shuxin.service.impl.stats;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.stats.StatsOrgProductDailyDao;
import com.baoquan.shuxin.dao.stats.StatsOrgProductDao;
import com.baoquan.shuxin.model.stats.StatsOrgProduct;
import com.baoquan.shuxin.model.stats.StatsProduct;
import com.baoquan.shuxin.service.spi.stats.StatsOrgProductService;
@Named
public class StatsOrgProductServiceImpl implements StatsOrgProductService{
	@Inject
	private StatsOrgProductDao statsOrgProductDao ;

	@Override
	public List<StatsOrgProduct> queryAllOrgProduct() {
		return statsOrgProductDao.queryAllOrgProduct();
	}

	@Override
	public StatsOrgProduct queryProductId(Long statsOrgProductProductId) {
		return statsOrgProductDao.queryProductId(statsOrgProductProductId);
	}

	@Override
	public void insertStatsOrgProductList(List<StatsOrgProduct> insertStatsOrgProductList) {
		statsOrgProductDao.insertStatsOrgProductList(insertStatsOrgProductList);
	}

	@Override
	public void updateStatsOrgProductList(List<StatsOrgProduct> updateStatsOrgProductList) {
		statsOrgProductDao.updateStatsOrgProductList(updateStatsOrgProductList);
	}
}
