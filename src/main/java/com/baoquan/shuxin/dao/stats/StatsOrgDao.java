package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface StatsOrgDao{

	List<Map<String, Object>> orgTop();

	List<Map<String, Object>> orgAll();

	Map<String, Object> findById(Long orgId);

}