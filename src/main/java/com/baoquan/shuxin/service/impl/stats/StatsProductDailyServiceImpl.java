package com.baoquan.shuxin.service.impl.stats;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.stats.StatsProductDailyDao;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsProductDailyService;
@Named
public class StatsProductDailyServiceImpl implements StatsProductDailyService{
	@Inject
	private StatsProductDailyDao statsProductDailyDao;

	@Override
	public void insertListStatsProductDaily(List<StatsProductDaily> maps) {
		statsProductDailyDao.insertListStatsProductDaily(maps);
	}

	@Override
	public List<StatsProductDaily> queryByTime(String stampTimeToday) {
		return statsProductDailyDao.queryByTime(stampTimeToday);
	}
}
