package com.sina.spider.model;

public class Weibo {
//	private String id = null;
//	private String poster = null;
//	private String content = null;
//	private String postTime = null;
//	private boolean hasPic = false;
//	private boolean isRepost = false;

	
	private String id = null; //微博id，对应新浪微博
	private int entryID;//对应数据库的ID
	
	public int getEntryID() {
		return entryID;
	}
	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}
	private String entryUrl = null; //微博对应的url
	private String text = null; //博主自己说的话，非转发微博中是博主自己说的话，转发微博中是转发理由
	private int likeNum = 0; //赞数
	private int shareNum = 0; //转发数
	private int commentNum = 0; //评论数
	private String sourceDevice  = null; //设备来源
	private int isShared = 0; //是否转发，默认0 ,0:原创 1：转发
	private String  publishTime; //发微博时间
	private int art;
	private int cultural;
	private int engineering;
	private int entertainment;
	private int game;
	private int living;
	private int medicine;
	private int science;
	private int social;
	private int sports;
	
	
	public int getArt() {
		return art;
	}
	public int getCultural() {
		return cultural;
	}
	public int getEngineering() {
		return engineering;
	}
	public int getEntertainment() {
		return entertainment;
	}
	public int getGame() {
		return game;
	}
	public int getLiving() {
		return living;
	}
	public int getMedicine() {
		return medicine;
	}
	public int getScience() {
		return science;
	}
	public int getSocial() {
		return social;
	}
	public int getSports() {
		return sports;
	}
	public void setArt(int art) {
		this.art = art;
	}
	public void setCultural(int cultural) {
		this.cultural = cultural;
	}
	public void setEngineering(int engineering) {
		this.engineering = engineering;
	}
	public void setEntertainment(int entertainment) {
		this.entertainment = entertainment;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public void setLiving(int living) {
		this.living = living;
	}
	public void setMedicine(int medicine) {
		this.medicine = medicine;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	public void setSports(int sports) {
		this.sports = sports;
	}
	
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntryUrl() {
		return entryUrl;
	}
	public void setEntryUrl(String entryUrl) {
		this.entryUrl = entryUrl;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getShareNum() {
		return shareNum;
	}
	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getSourceDevice() {
		return sourceDevice;
	}
	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}
	
	public int getIsShared() {
		return isShared;
	}
	public void setIsShared(int isShared) {
		this.isShared = isShared;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("id:\t\t\t").append(id).append("\n")
		  .append("entryUrl:\t\t").append(entryUrl).append("\n")
		  .append("text:\t\t\t").append(text).append("\n")
		  .append("publishTime:\t\t").append(publishTime).append("\n")
		  .append("likeNum:\t\t").append(likeNum).append("\n")
		  .append("shareNum:\t\t").append(shareNum).append("\n")
		  .append("commentNum:\t\t").append(commentNum).append("\n")
		  .append("sourceDevice:\t\t").append(sourceDevice).append("\n")
		  .append("isShared:\t\t").append(isShared).append("\n");
		return sb.toString();
	}
	
	
	

}
