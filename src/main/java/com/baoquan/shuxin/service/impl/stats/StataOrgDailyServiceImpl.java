package com.baoquan.shuxin.service.impl.stats;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.dao.stats.StatsOrgDailyDao;
import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgDailyService;

/**
 * Author:Zhoumc
 * Description: 机构交易统计（每日）接口实现
 * DATA:10:58 2017/8/2
 */
@Named
public class StataOrgDailyServiceImpl implements StatsOrgDailyService {

    @Inject
    private StatsOrgDailyDao statsOrgDailyDao;

    @Override
    public void insert(List<StatsOrgDaily> maps) {
        statsOrgDailyDao.insert(maps);
    }

    @Override
    public List<StatsOrgDaily> queryByTime(String stampTimeToday) {
        return statsOrgDailyDao.queryByTime(stampTimeToday);
    }
}
