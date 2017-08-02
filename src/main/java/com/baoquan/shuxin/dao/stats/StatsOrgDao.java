package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsOrg;
import com.baoquan.shuxin.model.stats.StatsProduct;

@Repository
public interface StatsOrgDao{

	List<Map<String, Object>> orgTop();

	List<Map<String, Object>> orgAll();

	Map<String, Object> findById(Long orgId);

	Long orgCount();

	List<StatsOrg> queryAllStatsOrg();

	StatsOrg queryById(Long orgId);

	void insertOrgList(List<StatsOrg> insertOrgList);

	void updateOrgList(List<StatsOrg> updateOrgList);

}