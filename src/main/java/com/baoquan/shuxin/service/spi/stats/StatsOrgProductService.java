package com.baoquan.shuxin.service.spi.stats;

import java.util.List;

import com.baoquan.shuxin.model.stats.StatsOrgProduct;
import com.baoquan.shuxin.model.stats.StatsProduct;

public interface StatsOrgProductService {

	List<StatsOrgProduct> queryAllOrgProduct();

	StatsOrgProduct queryProductId(Long statsOrgProductProductId, Long orgId);

	void insertStatsOrgProductList(List<StatsOrgProduct> insertStatsOrgProductList);

	void updateStatsOrgProductList(List<StatsOrgProduct> updateStatsOrgProductList);

}
