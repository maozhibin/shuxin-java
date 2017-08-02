package com.baoquan.shuxin.dao.product;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsProduct;

@Repository
public interface StatsProductDao{
	List<Map<String, Object>> productTop();

	List<Map<String, Object>> productList(Map<String, Object> map);

	Long productListCount(Map<String, Object> map);

	List<StatsProduct> queryAllStatsProduct();

}
