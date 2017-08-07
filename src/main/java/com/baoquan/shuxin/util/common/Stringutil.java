package com.baoquan.shuxin.util.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Stringutil {
	// 手机号判断
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
		String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	

	//邮箱验证
	public static boolean isEmail(String str) throws PatternSyntaxException {
		String regex = "[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}


	/**
	 * 为空处理
	 * @param str
	 * @return
	 */
	public static  Object notNull(Object str){
		if(str.equals("") && str== null ){
			return "";
		}else {
			return str;
		}

	}


}
