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

import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;
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
	 * 每天凌晨2点执行
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 0 2 * * *")
	public void updateStatsProduct(){
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeToday= DateUtil.stampToDateY(timeYesterday.toString());
		
		List<StatsProduct> statsProductList = statsProductService.queryAllStatsProduct();
		List<StatsProductDaily> listStatsProductDaily=statsProductDailyService.queryByTime(stampTimeToday);
		if(CollectionUtils.isEmpty(listStatsProductDaily)){
			return;
		}	
		
		//统计产品交易统计(每日)中的数据和产品交易统计中的数据productId中是否有相同,相同表明只需要更新,没有的话需要插入
		List<StatsProductDaily> insertList = new ArrayList<>();
		List<StatsProductDaily> updateList = new ArrayList<>();
		Long productDailyProductId = null;
		Long statsProductId = null;
		
		if(!CollectionUtils.isEmpty(statsProductList)){
			//查询需要更新的
			for (StatsProductDaily statsProductDaily : listStatsProductDaily) {
				productDailyProductId = statsProductDaily.getProductId();
				for (StatsProduct statsProduct : statsProductList) {
					statsProductId = statsProduct.getProductId();
					if(productDailyProductId.equals(statsProductId)){
						updateList.add(statsProductDaily);
					}
				}
			}
			//查询需要添加的
			for (StatsProductDaily statsProductDailyOld : listStatsProductDaily) {
				for (StatsProductDaily statsProductDailyupdate : updateList) {
					if(!statsProductDailyOld.equals(statsProductDailyupdate)){
						insertList.add(statsProductDailyOld);
					}
				}
			}
		}
		
		List<StatsProduct> insertStatsProductList = new ArrayList<>();
		List<StatsProduct> updateStatsProductList = new ArrayList<>();
		
	}
}
