package com.sina.spider.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Utils {
	private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	//public static Connection conn = DBConn.getConnection();
	
	/**
	 * 检测字符串是否为null，或空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str){
		if(str == null || str.trim().length() == 0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 将微博时间字符串转换成yyyyMMddHHmmSS
	 * 微博时间字符串有：
	 * 		xx分钟前
	 * 		今天 11:53 
	 * 		07月09日 13:36
	 * 		2010-09-23 19:55:38
	 * 		
	 * @param weiboTimeStr
	 * @return
	 */
	public static String parseDate(String weiboTimeStr){
		
		Calendar currentTime = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。 
		
		if(weiboTimeStr.contains("分钟前")){
			int minutes = Integer.parseInt(weiboTimeStr.split("分钟前")[0]);
			
			currentTime.add(Calendar.MINUTE, -minutes);//取当前日期的前一天. 
			
			return simpleDateTimeFormat.format(currentTime.getTime());
		}
		else if(weiboTimeStr.startsWith("今天")){
			String[] time = weiboTimeStr.split("天")[1].split(":");
			int hour = Integer.parseInt(time[0].substring(1));
			int minute = Integer.parseInt(time[1].substring(0, 2));
			
			currentTime.set(Calendar.HOUR_OF_DAY, hour);
			currentTime.set(Calendar.MINUTE, minute);
			
			return simpleDateTimeFormat.format(currentTime.getTime());
		}
		else if(weiboTimeStr.contains("月")){
			String[] time = weiboTimeStr.split("日")[1].split(":");
			int dayIndex = weiboTimeStr.indexOf("日") - 2;
			int month = Integer.parseInt(weiboTimeStr.substring(0, 2));
			int day = Integer.parseInt(weiboTimeStr.substring(dayIndex, dayIndex + 2));
			int hour = Integer.parseInt(time[0].substring(1));
			int minute = Integer.parseInt(time[1].substring(0, 2));
			
			currentTime.set(Calendar.MONTH, month - 1);
			currentTime.set(Calendar.DAY_OF_MONTH, day);
			currentTime.set(Calendar.HOUR_OF_DAY, hour);
			currentTime.set(Calendar.MINUTE, minute);
			
			return simpleDateTimeFormat.format(currentTime.getTime());
		}
		else if(weiboTimeStr.contains("-")){
			return weiboTimeStr.replace("-", "").replace(":", "").replace(" ", "").substring(0, 14);
		}
		else{
			System.out.println(">> Error: Unknown time format - " + weiboTimeStr);
		}
		
		return null;
	}
	
	
	/**
	 * 将异常账号写入文件
	 * @param account
	 * @throws IOException
	 */
	/*
	public static void writeAbnormalAccount(String account) throws IOException{
		FileWriter fileWriter = new FileWriter(Constants.ABNORMAL_ACCOUNT_PATH, true);
        fileWriter.write(account + "\r\n");
        fileWriter.flush();
		fileWriter.close();
	}
*/

	
	
}
	

