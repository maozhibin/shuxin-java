package com.baoquan.shuxin.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.model.stats.StatsOrg;
import com.baoquan.shuxin.model.stats.StatsOrgDaily;
import com.baoquan.shuxin.model.stats.StatsProduct;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgDailyService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;
import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsOrgTask {

	@Inject
	private StatsOrgDailyService statsOrgDailyService;

	@Inject
	private StatsOrgService statsOrgService;

	/**
	 * 每天凌晨2点执行
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 0 2 * * *")
	public void updateStatsOrg() throws ParseException {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeToday= DateUtil.stampToDateY(timeYesterday.toString());

		List<StatsOrg> statsOrgList = statsOrgService.queryAllStatsOrg();
		List<StatsOrgDaily> listStatsOrgDaily=statsOrgDailyService.queryByTime(stampTimeToday);
		if(CollectionUtils.isEmpty(listStatsOrgDaily)){
			return;
		}

		//统计机构交易(每日)中的数据和产品交易统计中的数据OrgId中是否有相同,相同表明只需要更新,没有的话需要插入
		List<StatsOrgDaily> insertList = new ArrayList<>();
		List<StatsOrgDaily> updateList = new ArrayList<>();
		Long orgDailyOrgId = null;
		Long statsOrgId = null;

		if(!CollectionUtils.isEmpty(statsOrgList)){
			//更新
			for (StatsOrgDaily statsOrgDaily : listStatsOrgDaily) {
				orgDailyOrgId = statsOrgDaily.getOrgId();
				for (StatsOrg statsOrg : statsOrgList) {
					statsOrgId = statsOrg.getOrgId();
					if(orgDailyOrgId.equals(statsOrgId)){
						updateList.add(statsOrgDaily);
					}
				}
			}
			//添加
			for (StatsOrgDaily statsOrgDaily : listStatsOrgDaily) {
				for (StatsOrgDaily statsProductDailyupdate : updateList) {
					if(!statsOrgDaily.equals(statsProductDailyupdate)){
						insertList.add(statsOrgDaily);
					}
				}
			}
		}
    }
}
