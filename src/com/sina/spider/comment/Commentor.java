package com.sina.spider.comment;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Commentor implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7422765796574667707L;
	
	@Text
	@HtmlField(cssPath="a[href~=/(u|[0-9a-zA-Z]*)/]")
	private String comName;
	
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	@Href
	@HtmlField(cssPath="a[href~=/(u|[0-9a-zA-Z]*)/]")
	private String comUrl;

	public String getComUrl() {
		return comUrl;
	}

	public void setComUrl(String comUrl) {
		this.comUrl = comUrl;
	}

}
