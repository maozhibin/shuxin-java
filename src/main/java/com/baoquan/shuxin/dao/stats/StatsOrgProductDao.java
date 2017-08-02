package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsOrgProduct;

@Repository
public interface StatsOrgProductDao {

	List<Map<String, Object>> productList(List<Long> idList);

	Map<String, Object> productByorgId(Long orgId);

	List<StatsOrgProduct> queryAllOrgProduct();

	StatsOrgProduct queryProductId(Long statsOrgProductProductId);

	void insertStatsOrgProductList(List<StatsOrgProduct> insertStatsOrgProductList);

	void updateStatsOrgProductList(List<StatsOrgProduct> updateStatsOrgProductList);
	
}