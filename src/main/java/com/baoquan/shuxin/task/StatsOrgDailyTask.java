package com.baoquan.shuxin.task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgDailyService;
import com.baoquan.shuxin.service.spi.user.UserProductService;
import com.baoquan.shuxin.util.common.DateUtil;

/**
 * Author:Zhoumc
 * Description:机构交易统计(每日)
 * DATA:10:27 2017/8/2
 */
@Component
public class StatsOrgDailyTask {


    @Inject
    private StatsOrgDailyService statsOrgDailyService;

    @Inject
    private UserProductService userProductService;

    /**
     *  凌晨1点执行添加
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void insert(){
        Date now = new Date();
        Date today = DateUtils.truncate(now, Calendar.DATE);
        Date Yesterday = DateUtils.addDays(today, -1);
        Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
        String stampTimeToday= DateUtil.stampToDateY(timeYesterday.toString());
        List<Map<String, Object>> listuserProduct = userProductService.queryByBuyTime(stampTimeToday);
        if(CollectionUtils.isEmpty(listuserProduct)){
            return;
        }
        List<StatsOrgDaily> maps = new ArrayList<>();
        for (Map<String, Object> map : listuserProduct) {
            StatsOrgDaily statsOrgDaily = new StatsOrgDaily();
            Long orgId = MapUtils.getLong(map, "orgId");
            String buyAmount = MapUtils.getString(map, "totalAmount");
            Long count =MapUtils.getLong(map, "count");
            BigDecimal totalAmount = new BigDecimal(buyAmount);

            statsOrgDaily.setOrgId(orgId);
            statsOrgDaily.setTotalAmount(totalAmount);
            statsOrgDaily.setOrderNum(count);
            statsOrgDaily.setReceiptNum(count);
            statsOrgDaily.setStatsDate(Yesterday);
            statsOrgDaily.setDateline(now.getTime());

            maps.add(statsOrgDaily);
        }
        statsOrgDailyService.insert(maps);
    }

}
