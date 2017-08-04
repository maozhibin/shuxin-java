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

import com.baoquan.shuxin.model.stats.StatsProduct;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
import com.baoquan.shuxin.service.spi.stats.StatsProductDailyService;
import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsProductTask {
	@Inject
	private StatsProductService statsProductService;
	@Inject
	private StatsProductDailyService statsProductDailyService;

	/**
	 * 每天凌晨1点10分执行
	 * 
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 10 1 * * *")
	//@Scheduled(fixedDelay=8000)
	public void updateStatsProduct() {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeToday = DateUtils.addDays(today, 0).getTime();//今天
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();// 昨天
		String stampTimeYesterday = DateUtil.stampToDateY(timeYesterday.toString());
		String stampTimeToday = DateUtil.stampToDateY(timeToday.toString());
		List<StatsProductDaily> listStatsProductDaily = statsProductDailyService.queryByTime(stampTimeYesterday);
		if (CollectionUtils.isEmpty(listStatsProductDaily)) {
			return;
		}

		List<StatsProduct> insertStatsProductList = new ArrayList<>();
		List<StatsProduct> updateStatsProductList = new ArrayList<>();
		for (StatsProductDaily statsProductDaily : listStatsProductDaily) {
			StatsProduct statsProduct = statsProductService.queryProductId(statsProductDaily.getProductId());
			if(statsProduct==null){
				statsProduct = statsProductService.setStatsProductDaily(statsProductDaily);
				insertStatsProductList.add(statsProduct);
			}else{
				//判断今天是否执行过,执行过就不让在执行
				Long dateline = statsProduct.getDateline();
				String stampToDateY = DateUtil.stampToDateY(dateline.toString());
				if(stampToDateY.equals(stampTimeToday)){
					return;
				}
				Long orderNum = statsProduct.getOrderNum() + statsProductDaily.getOrderNum();
				Long purchaseNum = statsProduct.getPurchaseNum() + statsProductDaily.getPurchaseNum();
				BigDecimal totalAmount = statsProduct.getTotalAmount().add(statsProductDaily.getTotalAmount());
				statsProduct.setOrderNum(orderNum);
				statsProduct.setPurchaseNum(purchaseNum);
				statsProduct.setProductId(statsProductDaily.getProductId());
				statsProduct.setTotalAmount(totalAmount);
				statsProduct.setDateline(now.getTime());
				updateStatsProductList.add(statsProduct);
			}
			
		}
		// 插入
		if (!CollectionUtils.isEmpty(insertStatsProductList)) {
			statsProductService.insertStatsProductList(insertStatsProductList);
		}
		if (!CollectionUtils.isEmpty(updateStatsProductList)) {
			// 更新
			statsProductService.updateStatsProductList(updateStatsProductList);
		}

	}
}
