package com.sina.spider.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;





public class Utils {
	private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Connection conn = DBConn.getConnection();
	
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
	 * 根据logType将日志写入相应的文件
	 * @param logType
	 * @param logStr
	 */
	/*
	public static void writeLog(int logType, String logStr){
		// 选取log类型
		String filePath = null;
		switch(logType){
			case LogType.SWITCH_ACCOUNT_LOG:
				filePath = Constants.SWITCH_ACCOUNT_LOG_PATH;
				break;
			case LogType.COMMENT_LOG:
				filePath = Constants.COMMENT_LOG_PATH;
				break;
			case LogType.REPOST_LOG:
				filePath = Constants.REPOST_LOG_PATH;
				break;
			case LogType.WEIBO_LOG:
				filePath = Constants.ABNORMAL_WEIBO_PATH;
				break;
			default:
				return;
		}
		
		// 写入日志
		try {
			FileWriter fileWriter = new FileWriter(filePath, true);
			if(logType == LogType.WEIBO_LOG){
				fileWriter.write(logStr + "\r\n");
			}
			else{
				fileWriter.write((new Date()).toString() + ": " + logStr + "\r\n");
			}
	        fileWriter.flush();
			fileWriter.close();
		} 
		catch (IOException e) {
			Log.error(e);
		}
	}
*/
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
	// 从url中解析出当前用户的ID
	public static String getUserIdFromUrl(String url) {
		int startIndex = url.lastIndexOf("/");
		int endIndex = url.indexOf("?");
		
		if(endIndex == -1){
			return url.substring(startIndex + 1); 
		}
		return url.substring(startIndex + 1,  endIndex);
	}
	
	// 从follow url中解析出当前用户的ID
	public static String getUserIdFromFollowUrl(String url) {
		int startIndex = 16;
		int endIndex = url.indexOf("/follow");

		return url.substring(startIndex,  endIndex);
	}
	
	// http://tp2.sinaimg.cn/2826608265/50/5667697175/1
	public static String getUserIdFromImgUrl(String url) {
		int startIndex = url.indexOf("sinaimg.cn/") + "sinaimg.cn/".length();
		String subStr = url.substring(startIndex);

		return subStr.substring(0, subStr.indexOf("/"));
	}
	
}
	

