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

import com.baoquan.shuxin.model.stats.StatsOrgProduct;
import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgProductDailyService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgProductService;
import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsOrgProductTask {
	@Inject
	private StatsOrgProductService statsOrgProductService;
	@Inject
	private StatsOrgProductDailyService statsOrgProductDailyService;

	/**
	 * 每天凌晨1点20分执行
	 * 
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 20 1 * * *")
	//@Scheduled(fixedDelay = 3000)
	public void updateStatsOrgProduct() {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeToday = DateUtils.addDays(today, 0).getTime();//今天
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();// 昨天
		String stampTimeYesterday = DateUtil.stampToDateY(timeYesterday.toString());
		String stampTimeToday = DateUtil.stampToDateY(timeToday.toString());
		List<StatsOrgProductDaily> OrgProductDailyList = statsOrgProductDailyService.queryByYesterDay(stampTimeYesterday);
		if (CollectionUtils.isEmpty(OrgProductDailyList)) {
			return;
		}

		List<StatsOrgProduct> insertStatsOrgProductList = new ArrayList<>();
		List<StatsOrgProduct> updateStatsOrgProductList = new ArrayList<>();

		for (StatsOrgProductDaily statsOrgProductDaily : OrgProductDailyList) {
			Long statsOrgProductProductId = statsOrgProductDaily.getProductId();
			StatsOrgProduct statsOrgProduct = statsOrgProductService.queryProductId(statsOrgProductProductId);
			if(statsOrgProduct==null){
				statsOrgProduct = new StatsOrgProduct();
				statsOrgProduct.setDateline(now.getTime());
				statsOrgProduct.setOrgId(statsOrgProductDaily.getOrgId());
				statsOrgProduct.setProductId(statsOrgProductDaily.getProductId());
				statsOrgProduct.setPurchaseNum(statsOrgProductDaily.getPurchaseNum());
				insertStatsOrgProductList.add(statsOrgProduct);
			}else{
				//判断今天是否执行过,执行过就不让在执行
				Long dateline = statsOrgProduct.getDateline();
				String stampToDateY = DateUtil.stampToDateY(dateline.toString());
				if(stampToDateY.equals(stampTimeToday)){
					return;
				}
				Integer purchaseNum = statsOrgProductDaily.getPurchaseNum() + statsOrgProduct.getPurchaseNum();
				statsOrgProduct.setPurchaseNum(purchaseNum);
				statsOrgProduct.setDateline(now.getTime());
				updateStatsOrgProductList.add(statsOrgProduct);
			}
			
			
		}
		// 插入
		if (!CollectionUtils.isEmpty(insertStatsOrgProductList)) {
			statsOrgProductService.insertStatsOrgProductList(insertStatsOrgProductList);
		}
		// 更新
		if (!CollectionUtils.isEmpty(updateStatsOrgProductList)) {
			statsOrgProductService.updateStatsOrgProductList(updateStatsOrgProductList);
		}

	}
}
