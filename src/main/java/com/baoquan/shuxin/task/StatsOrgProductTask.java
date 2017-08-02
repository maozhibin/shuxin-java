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
	 * 每天凌晨1点15分执行
	 * 
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 20 1 * * *")
	//@Scheduled(fixedDelay = 2000)
	public void updateStatsOrgProduct() {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();// 昨天
		String stampTimeToday = DateUtil.stampToDateY(timeYesterday.toString());

		List<StatsOrgProduct> StatsOrgProductList = statsOrgProductService.queryAllOrgProduct();
		List<StatsOrgProductDaily> OrgProductDailyList = statsOrgProductDailyService.queryByYesterDay(stampTimeToday);
		if (CollectionUtils.isEmpty(OrgProductDailyList)) {
			return;
		}
		List<StatsOrgProductDaily> insertList = new ArrayList<>();
		List<StatsOrgProductDaily> updateList = new ArrayList<>();
		Long productId = null;
		Long orgProductId = null;

		// 查询需要更新的
		for (int i = 0; i < OrgProductDailyList.size(); i++) {
			StatsOrgProductDaily statsOrgProductDaily = OrgProductDailyList.get(i);
			productId = statsOrgProductDaily.getProductId();
			for (StatsOrgProduct statsOrgProduct : StatsOrgProductList) {
				orgProductId = statsOrgProduct.getProductId();
				if (productId.equals(orgProductId)) {
					updateList.add(statsOrgProductDaily);
					OrgProductDailyList.remove(i);
					i--;
				}
			}
		}
		// 查询需要添加的
		for (StatsOrgProductDaily statsOrgProductDaily : OrgProductDailyList) {
			insertList.add(statsOrgProductDaily);
		}

		List<StatsOrgProduct> insertStatsOrgProductList = new ArrayList<>();
		List<StatsOrgProduct> updateStatsOrgProductList = new ArrayList<>();

		for (StatsOrgProductDaily statsOrgProductDaily : updateList) {// 更新
			Long statsOrgProductProductId = statsOrgProductDaily.getProductId();
			StatsOrgProduct statsOrgProduct = statsOrgProductService.queryProductId(statsOrgProductProductId);
			Integer purchaseNum = statsOrgProductDaily.getPurchaseNum() + statsOrgProduct.getPurchaseNum();
			statsOrgProduct.setPurchaseNum(purchaseNum);
			updateStatsOrgProductList.add(statsOrgProduct);
		}

		for (StatsOrgProductDaily statsOrgProductDaily : insertList) {// 插入
			StatsOrgProduct statsOrgProduct = new StatsOrgProduct();
			statsOrgProduct.setDateline(now.getTime());
			statsOrgProduct.setOrgId(statsOrgProductDaily.getOrgId());
			statsOrgProduct.setProductId(statsOrgProductDaily.getProductId());
			statsOrgProduct.setPurchaseNum(statsOrgProductDaily.getPurchaseNum());
			insertStatsOrgProductList.add(statsOrgProduct);
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
