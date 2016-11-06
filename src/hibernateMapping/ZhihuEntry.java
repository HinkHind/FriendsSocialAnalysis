package hibernateMapping;
// Generated 2016-11-6 16:05:19 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * ZhihuEntry generated by hbm2java
 */
public class ZhihuEntry implements java.io.Serializable {

	private Integer entryId;
	private int zhihuId;
	private String contentHolder;
	private Date publishedTime;
	private boolean hasRead;
	private String classHolder;

	public ZhihuEntry() {
	}

	public ZhihuEntry(int zhihuId, Date publishedTime, boolean hasRead) {
		this.zhihuId = zhihuId;
		this.publishedTime = publishedTime;
		this.hasRead = hasRead;
	}

	public ZhihuEntry(int zhihuId, String contentHolder, Date publishedTime, boolean hasRead, String classHolder) {
		this.zhihuId = zhihuId;
		this.contentHolder = contentHolder;
		this.publishedTime = publishedTime;
		this.hasRead = hasRead;
		this.classHolder = classHolder;
	}

	public Integer getEntryId() {
		return this.entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public int getZhihuId() {
		return this.zhihuId;
	}

	public void setZhihuId(int zhihuId) {
		this.zhihuId = zhihuId;
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

}
