package com.baoquan.shuxin.service.spi.stats;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.stats.StatsProductDaily;

public interface StatsProductDailyService {

	void insertListStatsProductDaily(List<StatsProductDaily> maps);

	List<StatsProductDaily> queryByTime(String stampTimeToday);

	List<Map<String, Object>> findByTimeYesterday(String stampTimeToday);


}
