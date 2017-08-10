package com.baoquan.shuxin.task;

import java.math.BigDecimal;
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
	//@Scheduled(fixedDelay = 8000)
	public void updateStatsOrg() throws ParseException {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeToday = DateUtils.addDays(today, 0).getTime();//今天
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeYesterday = DateUtil.stampToDateY(timeYesterday.toString());
		String stampTimeToday= DateUtil.stampToDateY(timeToday.toString());

		List<StatsOrgDaily> listStatsOrgDaily=statsOrgDailyService.queryByTime(stampTimeYesterday);
		if(CollectionUtils.isEmpty(listStatsOrgDaily)){
			return;
		}
		List<StatsOrg> insertList = new ArrayList<>();
		List<StatsOrg> updateList = new ArrayList<>();

		for (StatsOrgDaily statsOrgDaily : listStatsOrgDaily){
			Long orgId = statsOrgDaily.getOrgId();
			StatsOrg statsOrg = statsOrgService.queryById(orgId);
			if (statsOrg == null){
				statsOrg = new StatsOrg();
				statsOrg.setDateline(now.getTime());
				statsOrg.setOrderNum(statsOrgDaily.getOrderNum());
				statsOrg.setTotalAmount(statsOrgDaily.getTotalAmount());
				statsOrg.setReceiptNum(statsOrgDaily.getReceiptNum());
				statsOrg.setOrgId(statsOrgDaily.getOrgId());
				insertList.add(statsOrg);
			}else {
				Long dateline = statsOrg.getDateline();
				String stampToDate = DateUtil.stampToDateY(dateline.toString());
				//判断今天是否执行过，执行过就不在执行，一天只执行一次
				if (stampToDate.equals(stampTimeToday)){
					return;
				}
				Long receiptNum = statsOrgDaily.getReceiptNum() + statsOrgDaily.getReceiptNum();
				statsOrg.setReceiptNum(receiptNum);
				updateList.add(statsOrg);
			}
		}

		/**
		 * 添加
		 */
		if (!CollectionUtils.isEmpty(insertList)){
			statsOrgService.insertOrgList(insertList);
		}
		/**
		 * 更新
		 */
		if (!CollectionUtils.isEmpty(updateList)){
			statsOrgService.updateOrgtList(updateList);
		}
    }
}
