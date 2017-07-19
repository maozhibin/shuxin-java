package com.baoquan.shuxin.service.spi.stats;

import java.util.List;
import java.util.Map;

public interface StatsOrgService {

	List<Map<String, Object>> orgTopOrAll(Integer type);

	List<Map<String, Object>> orgListByOrgName(String orgName);


}
