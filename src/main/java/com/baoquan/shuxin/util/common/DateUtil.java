package com.baoquan.shuxin.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/*
	 * 将时间转换为时间戳
	 */
	public static long dateToStamp(String s) {
		Long ts = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = simpleDateFormat.parse(s);
			ts = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}

}
