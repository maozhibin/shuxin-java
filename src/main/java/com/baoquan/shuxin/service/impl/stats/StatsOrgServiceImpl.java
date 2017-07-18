package com.baoquan.shuxin.service.impl.stats;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.stats.StatsOrgDao;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;

@Named
public class StatsOrgServiceImpl implements StatsOrgService{
	@Inject
	private StatsOrgDao statsOrgDao;

	@Override
	public List<Map<String, Object>> orgTop() {
		return statsOrgDao.orgTop();
	}
}
