package hibernateMapping;
// Generated 2016-11-6 18:04:40 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * CsdnEntry generated by hbm2java
 */
public class CsdnEntry implements java.io.Serializable {

	private Integer entryId;
	private CsdnUrl csdnUrl;
	private String contentHolder;
	private Date publishedTime;
	private boolean hasRead;
	private String classHolder;

	public CsdnEntry() {
	}

	public CsdnEntry(CsdnUrl csdnUrl, Date publishedTime, boolean hasRead) {
		this.csdnUrl = csdnUrl;
		this.publishedTime = publishedTime;
		this.hasRead = hasRead;
	}

	public CsdnEntry(CsdnUrl csdnUrl, String contentHolder, Date publishedTime, boolean hasRead, String classHolder) {
		this.csdnUrl = csdnUrl;
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

	public CsdnUrl getCsdnUrl() {
		return this.csdnUrl;
	}

	public void setCsdnUrl(CsdnUrl csdnUrl) {
		this.csdnUrl = csdnUrl;
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
