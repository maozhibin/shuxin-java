package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.model.stats.StatsProductDaily;

@Repository
public interface StatsProductDailyDao {

	void insertListStatsProductDaily(List<StatsProductDaily> maps);

	List<StatsProductDaily> queryByTime(String stampTimeToday);

	List<Map<String, Object>> countOrgTask(String stampTimeToday);

	//添加
	void insert(List<StatsOrgDaily> maps);
}