package com.sina.spider.utils;

public interface Upload {
	
	/**
	 * 修改新url的标记，改为已经爬过
	 * @param url
	 * @return
	 */
	public boolean updateTag(String url);
	
	
	public boolean updateWeiNum();
	public boolean updateZhihuNum();
	public boolean updateCSDNNum();
	
	/**
	 * 
	 * @return
	 */
	public boolean insertWeibo();
	
	/**
	 * 
	 * @return
	 */
	public boolean insertZhihu();
	
	/**
	 * 
	 * @return
	 */
	public boolean insertCSDN();
	

}
