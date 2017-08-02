package com.baoquan.shuxin.service.spi.product;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.stats.StatsProduct;
import com.baoquan.shuxin.model.stats.StatsProductDaily;

public interface StatsProductService {

	List<Map<String, Object>> productTop();

	List<Map<String, Object>> productList(Map<String, Object> map);

	Long productListCount(Map<String, Object> map);

	List<StatsProduct> queryAllStatsProduct();


	StatsProduct setStatsProductDaily(StatsProductDaily statsProductDaily);


	void insertStatsProductList(List<StatsProduct> insertStatsProductList);

	StatsProduct queryProductId(Long productId);

	void updateStatsProductList(List<StatsProduct> updateStatsProductList);

}
