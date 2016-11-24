package com.zhihu.spider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	

	public static String getDate(String str) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		str  = str.substring(4);
		if(str.startsWith("20"));
		else if (str.startsWith("昨天")) {
			str = df.format(getPrtDay(new Date())) + str.substring(3);
		}else{
			str = df.format(new Date()) + str;
		}
		str = str.replace("-", "");
		str = str.replace(":", "");
		return str;
		
	}
	
	public static Date getPrtDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        date = calendar.getTime();  
        return date;  
    }  
	

}
