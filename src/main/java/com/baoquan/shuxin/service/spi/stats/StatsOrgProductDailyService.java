package com.baoquan.shuxin.service.spi.stats;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;

public interface StatsOrgProductDailyService {

	void insertList(List<StatsOrgProductDaily> list);

	List<StatsOrgProductDaily> queryByYesterDay(String stampTimeYesterday);


}
