package com.baoquan.shuxin.task;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baoquan.shuxin.util.common.DateUtil;

@Component
public class StatsProductTask {
	/**
	 * 每天凌晨2点执行
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 0 2 * * *")
	public void updateStatsProduct(){
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Date Yesterday = DateUtils.addDays(today, -1);
		Long timeYesterday = DateUtils.addDays(today, -1).getTime();//昨天
		String stampTimeToday= DateUtil.stampToDateY(timeYesterday.toString());
		
		
	}
}
