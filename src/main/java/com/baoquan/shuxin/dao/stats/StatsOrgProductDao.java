package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface StatsOrgProductDao {

	List<Map<String, Object>> productList(List<Long> idList);

	Map<String, Object> productByorgId(Long orgId);
	
}