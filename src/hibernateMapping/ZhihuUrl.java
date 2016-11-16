package hibernateMapping;
// Generated 2016-11-15 16:09:53 by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * ZhihuUrl generated by hbm2java
 */
public class ZhihuUrl implements java.io.Serializable {

	private Integer zhihuId;
	private String zhihuUrl;
	private int count;
	private Set friends = new HashSet(0);
	private Set zhihuEntries = new HashSet(0);

	public ZhihuUrl() {
	}

	public ZhihuUrl(int count) {
		this.count = count;
	}

	public ZhihuUrl(String zhihuUrl, int count, Set friends, Set zhihuEntries) {
		this.zhihuUrl = zhihuUrl;
		this.count = count;
		this.friends = friends;
		this.zhihuEntries = zhihuEntries;
	}

	public Integer getZhihuId() {
		return this.zhihuId;
	}

	public void setZhihuId(Integer zhihuId) {
		this.zhihuId = zhihuId;
	}

	public String getZhihuUrl() {
		return this.zhihuUrl;
	}

	public void setZhihuUrl(String zhihuUrl) {
		this.zhihuUrl = zhihuUrl;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Set getFriends() {
		return this.friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}

	public Set getZhihuEntries() {
		return this.zhihuEntries;
	}

	public void setZhihuEntries(Set zhihuEntries) {
		this.zhihuEntries = zhihuEntries;
	}

}
