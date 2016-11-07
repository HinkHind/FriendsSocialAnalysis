package hibernateMapping;
// Generated 2016-11-7 21:51:51 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * WeiboEntry generated by hbm2java
 */
public class WeiboEntry implements java.io.Serializable {

	private Integer entryId;
	private int weiboId;
	private String contentHolder;
	private Date publishedTime;
	private boolean hasRead;
	private String classHolder;
	private String entryUrl;
	private String text;
	private Integer likeNumber;
	private Integer shareNumber;
	private Integer commentNumber;
	private String sourceDevice;
	private Boolean isShared;
	private Integer originLikeNumber;
	private Integer originShareNumber;
	private String originText;
	private Integer originCommentNumber;

	public WeiboEntry() {
	}

	public WeiboEntry(int weiboId, Date publishedTime, boolean hasRead) {
		this.weiboId = weiboId;
		this.publishedTime = publishedTime;
		this.hasRead = hasRead;
	}

	public WeiboEntry(int weiboId, String contentHolder, Date publishedTime, boolean hasRead, String classHolder,
			String entryUrl, String text, Integer likeNumber, Integer shareNumber, Integer commentNumber,
			String sourceDevice, Boolean isShared, Integer originLikeNumber, Integer originShareNumber,
			String originText, Integer originCommentNumber) {
		this.weiboId = weiboId;
		this.contentHolder = contentHolder;
		this.publishedTime = publishedTime;
		this.hasRead = hasRead;
		this.classHolder = classHolder;
		this.entryUrl = entryUrl;
		this.text = text;
		this.likeNumber = likeNumber;
		this.shareNumber = shareNumber;
		this.commentNumber = commentNumber;
		this.sourceDevice = sourceDevice;
		this.isShared = isShared;
		this.originLikeNumber = originLikeNumber;
		this.originShareNumber = originShareNumber;
		this.originText = originText;
		this.originCommentNumber = originCommentNumber;
	}

	public Integer getEntryId() {
		return this.entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public int getWeiboId() {
		return this.weiboId;
	}

	public void setWeiboId(int weiboId) {
		this.weiboId = weiboId;
	}

	public String getContentHolder() {
		return this.contentHolder;
	}

	public void setContentHolder(String contentHolder) {
		this.contentHolder = contentHolder;
	}

	public Date getPublishedTime() {
		return this.publishedTime;
	}

	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	public boolean isHasRead() {
		return this.hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}

	public String getClassHolder() {
		return this.classHolder;
	}

	public void setClassHolder(String classHolder) {
		this.classHolder = classHolder;
	}

	public String getEntryUrl() {
		return this.entryUrl;
	}

	public void setEntryUrl(String entryUrl) {
		this.entryUrl = entryUrl;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getLikeNumber() {
		return this.likeNumber;
	}

	public void setLikeNumber(Integer likeNumber) {
		this.likeNumber = likeNumber;
	}

	public Integer getShareNumber() {
		return this.shareNumber;
	}

	public void setShareNumber(Integer shareNumber) {
		this.shareNumber = shareNumber;
	}

	public Integer getCommentNumber() {
		return this.commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getSourceDevice() {
		return this.sourceDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	public Boolean getIsShared() {
		return this.isShared;
	}

	public void setIsShared(Boolean isShared) {
		this.isShared = isShared;
	}

	public Integer getOriginLikeNumber() {
		return this.originLikeNumber;
	}

	public void setOriginLikeNumber(Integer originLikeNumber) {
		this.originLikeNumber = originLikeNumber;
	}

	public Integer getOriginShareNumber() {
		return this.originShareNumber;
	}

	public void setOriginShareNumber(Integer originShareNumber) {
		this.originShareNumber = originShareNumber;
	}

	public String getOriginText() {
		return this.originText;
	}

	public void setOriginText(String originText) {
		this.originText = originText;
	}

	public Integer getOriginCommentNumber() {
		return this.originCommentNumber;
	}

	public void setOriginCommentNumber(Integer originCommentNumber) {
		this.originCommentNumber = originCommentNumber;
	}

}
