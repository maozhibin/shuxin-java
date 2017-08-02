package com.baoquan.shuxin.service.spi.stats;

import java.util.List;

import com.baoquan.shuxin.model.stats.StatsOrgDaily;

/**
 * Author:Zhoumc
 * Description: 机构交易统计（每日）接口
 * DATA:10:55 2017/8/2
 */
public interface StatsOrgDailyService {

    //添加
    void insert(List<StatsOrgDaily> maps);

    //依据时间查询
    List<StatsOrgDaily> queryByTime(String stampTimeToday);
}
