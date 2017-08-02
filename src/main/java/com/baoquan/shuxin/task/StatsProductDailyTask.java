package com.baoquan.shuxin.task;

import java.math.BigDecimal;
import java.text.ParseException;
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

import com.baoquan.shuxin.dao.stats.StatsProductDailyDao;
import com.baoquan.shuxin.dao.user.UserProductDao;
import com.baoquan.shuxin.model.stats.StatsProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsProductDailyService;
import com.baoquan.shuxin.service.spi.user.UserProductService;
import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsProductDailyTask {
	@Inject
	private StatsProductDailyService statsProductDailyService;
	@Inject
	private UserProductService userProductService;
	/**
	 * 每天凌晨1点执行
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 0 1 * * *")
	public void updateStatsOrgDaily(){
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Date Yesterday = DateUtils.addDays(today, -1);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeToday= DateUtil.stampToDateY(timeYesterday.toString());
		List<Map<String, Object>> listuserProduct = userProductService.queryByBuyTime(stampTimeToday);
		if(CollectionUtils.isEmpty(listuserProduct)){
			return;
		}
		List<StatsProductDaily> maps = new ArrayList<>();;
		for (Map<String, Object> map : listuserProduct) {
			StatsProductDaily statsProductDaily = new StatsProductDaily();
			Long productId = MapUtils.getLong(map, "productId");
			String buyAmount = MapUtils.getString(map, "buyAmount");
			Long count =MapUtils.getLong(map, "count");
			BigDecimal totalAmount = new BigDecimal(buyAmount);
			
			statsProductDaily.setProductId(productId);
			statsProductDaily.setTotalAmount(totalAmount);
			statsProductDaily.setOrderNum(count);
			statsProductDaily.setPurchaseNum(count);
			statsProductDaily.setStatsDate(Yesterday);
			statsProductDaily.setDateline(now.getTime());
			
			maps.add(statsProductDaily);
		}
		statsProductDailyService.insertListStatsProductDaily(maps);
    }
	
}
