package com.baoquan.shuxin.service.spi.stats;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.stats.StatsOrg;
import com.baoquan.shuxin.model.stats.StatsProduct;

public interface StatsOrgService {

	List<Map<String, Object>> orgTopOrAll(Map<String, Object> parms);

	List<Map<String, Object>> orgListByOrgName(String orgName);

	Long orgCount();

	List<StatsOrg> queryAllStatsOrg();

	StatsOrg queryById(Long orgId);

	void insertOrgList(List<StatsOrg> insertOrgList);

	void updateOrgtList(List<StatsOrg> updateOrgtList);


}
