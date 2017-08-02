package com.baoquan.shuxin.service.spi.product;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.stats.StatsProduct;

public interface StatsProductService {

	List<Map<String, Object>> productTop();

	List<Map<String, Object>> productList(Map<String, Object> map);

	Long productListCount(Map<String, Object> map);

	List<StatsProduct> queryAllStatsProduct();

}
