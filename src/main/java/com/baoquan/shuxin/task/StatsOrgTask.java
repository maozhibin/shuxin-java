package com.baoquan.shuxin.task;

import java.text.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class StatsOrgTask {
	/**
	 * 每天凌晨2点执行
	 * @throws ParseException
	 */
	@Scheduled(cron = "0 0 2 * * *")
	public void updateStatsOrg() throws ParseException {
		 
    }
//	
//	 @Scheduled(fixedRate=2000)  // 每隔2秒执行一次 
//     public void scheduleMethod(){   
//               System.out.println("Hello world...");   
//    }
}
