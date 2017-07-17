package com.baoquan.shuxin.third.util.shengda;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String date() {
        return sdf.format(Calendar.getInstance().getTime());
    }

    public static String year(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.YEAR, i);
        return sdf.format(ca.getTime());
    }

    public static String month(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, i);
        return sdf.format(ca.getTime());
    }

    public static String day(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, i);
        return sdf.format(ca.getTime());
    }

    public static String hour(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.HOUR, i);
        return sdf.format(ca.getTime());
    }

    public static String minute(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MINUTE, i);
        return sdf.format(ca.getTime());
    }

    public static String second(int i) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.SECOND, i);
        return sdf.format(ca.getTime());
    }

}
