package com.sina.spider.model;

import com.geccocrawler.gecco.annotation.Text;

public class Weibo {
//	private String id = null;
//	private String poster = null;
//	private String content = null;
//	private String postTime = null;
//	private boolean hasPic = false;
//	private boolean isRepost = false;
//	@Override
//	public String toString(){
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("id:\t\t").append(id).append("\n")
//		  .append("poster:\t\t").append(poster).append("\n")
//		  .append("content:\t").append(content).append("\n")
//		  .append("hasPic:\t\t").append(hasPic).append("\n")
//		  .append("isRepost:\t").append(isRepost).append("\n");
//		
//		return sb.toString();
//	}
	
	private String id = null; //微博id
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
	public boolean isShared() {
		return isShared;
	}
	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}
	private String entryUrl = null; //微博对应的url
	private String text = null; //博主自己说的话，非转发微博中是博主自己说的话，转发微博中是转发理由
	private int likeNum = 0; //赞数
	private int shareNum = 0; //转发数
	private int commentNum = 0; //评论数
	private String sourceDevice  = null; //设备来源
	private boolean isShared = false; //是否转发，默认false
	
	
	
	

}
