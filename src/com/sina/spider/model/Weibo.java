package com.sina.spider.model;

public class Weibo {
//	private String id = null;
//	private String poster = null;
//	private String content = null;
//	private String postTime = null;
//	private boolean hasPic = false;
//	private boolean isRepost = false;

	
	private String id = null; //微博id
	private String entryUrl = null; //微博对应的url
	private String text = null; //博主自己说的话，非转发微博中是博主自己说的话，转发微博中是转发理由
	private int likeNum = 0; //赞数
	private int shareNum = 0; //转发数
	private int commentNum = 0; //评论数
	private String sourceDevice  = null; //设备来源
	private int isShared = 0; //是否转发，默认0 ,0:原创 1：转发
	private String  publishTime; //发微博时间
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
