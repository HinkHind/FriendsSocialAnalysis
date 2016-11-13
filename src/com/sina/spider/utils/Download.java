package com.sina.spider.utils;

import java.util.ArrayList;


public interface Download {
	
	/**
	 * 得到所有未爬过的微博url
	 * @return
	 */
	public ArrayList<String> getNewWeiboUrl();
	
	/**
	 * 得到所有未爬过的知乎url
	 * @return
	 */
	public ArrayList<String> getNewZhihuUrl();
	
	/**
	 * 得到所有未爬过的csdn的url
	 * @return
	 */
	public ArrayList<String> getNewCSDNUrl();
	
	/**
	 * 根据用户ID得到上次爬取时微博数量
	 * @param userID
	 * @return
	 */
	public int getWeiboNumByUser(String userID);
	
	/**
	 * 根据用户ID得到上次爬取时知乎数量
	 * @param userID
	 * @return
	 */
	public int getZhihuNUmByUser(String userID);

	/**
	 * 根据用户ID得到上次爬取时CSDN数量
	 * @param userID
	 * @return
	 */
	public int getCSDNNUmByUser(String userID);
	
	
}

