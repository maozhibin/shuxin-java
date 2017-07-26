package com.baoquan.shuxin.service.spi.stats;

import java.util.List;
import java.util.Map;

public interface StatsOrgService {

	List<Map<String, Object>> orgTopOrAll(Map<String, Object> parms);

	List<Map<String, Object>> orgListByOrgName(String orgName);

	Long orgCount();


}
