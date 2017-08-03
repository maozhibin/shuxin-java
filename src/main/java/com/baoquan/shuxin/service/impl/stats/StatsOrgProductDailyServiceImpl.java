package com.baoquan.shuxin.service.impl.stats;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.stats.StatsOrgProductDailyDao;
import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgProductDailyService;

@Named
public class StatsOrgProductDailyServiceImpl implements StatsOrgProductDailyService{
	@Inject
	private StatsOrgProductDailyDao statsOrgProductDailyDao;

	@Override
	public void insertList(List<StatsOrgProductDaily> list) {
		statsOrgProductDailyDao.insertList(list);
	}

	@Override
	public List<StatsOrgProductDaily> queryByYesterDay(String stampTimeToday) {
		return statsOrgProductDailyDao.queryByYesterDay(stampTimeToday);
	}

	@Override
	public List<Map<String, Object>> findByTimeOrgTask(String stampTimeToday) {
		return statsOrgProductDailyDao.findByTimeOrgTask(stampTimeToday);
	}


}
