package com.baoquan.shuxin.util.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {
	
	public static void main(String[] args) {
		System.out.println(stampToDate("1484668800000"));
		System.out.println(dateToStampS("2017-01-18 01:00:00"));
	}
	
	
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
	
	public static long dateToStampS(String time) {
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
	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}
	
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
