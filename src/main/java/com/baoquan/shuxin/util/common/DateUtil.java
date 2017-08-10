package com.baoquan.shuxin.util.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {
	/**
	 * 将时间yyyy-MM-dd  转换为时间戳
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
	
	/**
	 * 将时间yyyy-MM-dd HH:mm:ss 转换为时间戳
	 */
	public static long dateToStampYY(String time) {
		Long ts = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = simpleDateFormat.parse(time);
			ts = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	public static void main(String[] args) {
		System.out.println(dateToStampYY("2017-08-09 01:00:00"));
		System.out.println(dateToStampYY("2017-07-27 18:00:00"));
		System.out.println(dateToStampYY("2017-07-27 20:00:00"));
		System.out.println(dateToStampYY("2017-07-27 22:00:00"));
		System.out.println(dateToStampYY("2017-07-27 23:00:00"));
		System.out.println(stampToDate("1502211600000"));

	}
	
	/**
	 * 将时间戳转换为时间yyyy-MM-dd HH:mm:ss
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}
	/**
	 * 将时间戳转换为时间yyyy-MM-dd
	 * @param s
	 * @return
	 */
	public static String stampToDateY(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}
	

	/**
	 * 今天零点零分零秒的毫秒数
	 */
	public static long zero(String s) {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Long time=null;
		try {
			Date date = fmt.parse(s);
			Date today = DateUtils.truncate(date, Calendar.DATE);
			time=today.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 今天23点59分59秒的毫秒数
	 */
	public static long twelve(String s) {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Long time=null;
		try {
			Date date = fmt.parse(s);
			Date today = DateUtils.truncate(date, Calendar.DATE);
			Date lastday = DateUtils.addDays(today, +1);
			time=lastday.getTime()-1;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
}
