package com.baoquan.shuxin.task;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.model.stats.StatsOrgProductDaily;
import com.baoquan.shuxin.service.spi.stats.StatsOrgProductDailyService;
import com.baoquan.shuxin.service.spi.stats.StatsProductDailyService;
import com.baoquan.shuxin.service.spi.user.UserProductService;
import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsOrgProductDailyTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(StatsOrgProductDailyTask.class);
	@Inject
	private StatsOrgProductDailyService statsOrgProductDailyService;
	@Inject
	private UserProductService userProductService;
	/**
	 * 每天凌晨1点15分执行
	 * 
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 15 1 * * *")
	//@Scheduled(fixedDelay=8000)
	public void updateStatsOrgProductDaily() {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();// 昨天
		String stampTimeYesterday = DateUtil.stampToDateY(timeYesterday.toString());
		List<Map<String, Object>> userProductList = userProductService.findByTimeYesterday(stampTimeYesterday);
		if(CollectionUtils.isEmpty(userProductList)){
			return;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		List<StatsOrgProductDaily> list = new ArrayList<>();
		for (Map<String, Object> map : userProductList) {
			Long productId = MapUtils.getLong(map, "productId");
			Long orgId = MapUtils.getLong(map, "userId");
			Integer purchaseNum = MapUtils.getInteger(map, "count");
			String payAmount = MapUtils.getString(map, "payAmount");
			BigDecimal totalAmount = new BigDecimal(payAmount);
			StatsOrgProductDaily orgProductDaily = new StatsOrgProductDaily();
			orgProductDaily.setOrgId(orgId);
			orgProductDaily.setProductId(productId);
			orgProductDaily.setPurchaseNum(purchaseNum);
			orgProductDaily.setTotalAmount(totalAmount);
			try {
				Date date = sdf.parse(stampTimeYesterday);
				orgProductDaily.setStatsDate(date);
			} catch (ParseException e) {
				LOGGER.error("时间格式化错误");
			}
			orgProductDaily.setDateline(now.getTime());
			list.add(orgProductDaily);
		}
		statsOrgProductDailyService.insertList(list);
	}
}
