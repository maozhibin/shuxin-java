package com.baoquan.shuxin.dao.stats;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.stats.StatsOrgDaily;

@Repository
public interface StatsOrgDailyDao {

    //添加
    void insert(List<StatsOrgDaily> maps);

    //依据时间查询
    List<StatsOrgDaily> queryByTime(String stampTimeToday);
 
}