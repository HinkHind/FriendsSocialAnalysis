package hibernateMapping;
// Generated 2016-11-5 19:39:13 by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * CsdnUrl generated by hbm2java
 */
public class CsdnUrl implements java.io.Serializable {

	private Integer csdnId;
	private String csdnUrl;
	private int count;
	private String attributeHolder;
	private Set friends = new HashSet(0);

	public CsdnUrl() {
	}

	public CsdnUrl(int count) {
		this.count = count;
	}

	public CsdnUrl(String csdnUrl, int count, String attributeHolder, Set friends) {
		this.csdnUrl = csdnUrl;
		this.count = count;
		this.attributeHolder = attributeHolder;
		this.friends = friends;
	}

	public Integer getCsdnId() {
		return this.csdnId;
	}

	public void setCsdnId(Integer csdnId) {
		this.csdnId = csdnId;
	}

	public String getCsdnUrl() {
		return this.csdnUrl;
	}

	public void setCsdnUrl(String csdnUrl) {
		this.csdnUrl = csdnUrl;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAttributeHolder() {
		return this.attributeHolder;
	}

	public void setAttributeHolder(String attributeHolder) {
		this.attributeHolder = attributeHolder;
	}

	public Set getFriends() {
		return this.friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}

}