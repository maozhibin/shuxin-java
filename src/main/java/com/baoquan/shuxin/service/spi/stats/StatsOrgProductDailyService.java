package com.baoquan.shuxin.service.spi.stats;

import java.util.List;

import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;

public interface StatsOrgProductDailyService {

	void insertList(List<StatsOrgProductDaily> list);

	List<StatsOrgProductDaily> queryByYesterDay(String stampTimeYesterday);

}
