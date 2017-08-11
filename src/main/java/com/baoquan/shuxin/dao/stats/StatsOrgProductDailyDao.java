package com.baoquan.shuxin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;

@Repository
public interface StatsOrgProductDailyDao {

	void insertList(List<StatsOrgProductDaily> list);

	List<StatsOrgProductDaily> queryByYesterDay(String stampTimeYesterDay);

	List<Map<String, Object>> findByTimeOrgTask(String stampTimeToday);

}