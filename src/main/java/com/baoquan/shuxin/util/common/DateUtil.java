package com.baoquan.shuxin.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/*
	 * 将时间转换为时间戳
	 */
	public static long dateToStamp(String time) {
		Long ts = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = simpleDateFormat.parse(time);
			ts = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}

	public static long dateToStamp(Long time) {
		Long ts = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = simpleDateFormat.parse(String.valueOf(time));
			ts = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}


	public static void main(String[] args) {
		System.out.println(dateToStamp("2017-7-10") / 1000);
	}
}
