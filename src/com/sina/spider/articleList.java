package com.sina.spider;


import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="http://weibo.cn/{userID}", pipelines = "SaveArticlePipeline")
public class articleList implements HtmlBean{

	private static final long serialVersionUID = -8062180093723754955L;
	
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String userID;
	
	@HtmlField(cssPath="body")
	private String content;
	
	@HtmlField(cssPath="span.tc")
	private String weiboNum;
	
	@Href
	@HtmlField(cssPath="div.tip2:nth-child(2) > a:nth-child(2)")
	private String following;
	


	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getWeiboNum() {
		return weiboNum;
	}

	public void setWeiboNum(String weiboNum) {
		this.weiboNum = weiboNum;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void Start(String startUrl) {
		HttpGetRequest start = new HttpGetRequest(startUrl);
		start.addCookie("SCF", "Aiz7B_dfVk9D3BiMgBbIj07Xcwszz2tU-ROzsW2yOxK1sou9NNl-mdu_K9-FYFHig6fbMtSf9PfbEWtrs8FHdAI.");
		start.addCookie("ALF", "1511260357");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFhomYZzEzSQcHc5QwsHnHV5JpX5K2hUgL.Fo-0SK.Xeo50Sh52dJLoIEBLxKnLB.qLB.BLxK-L1hMLBK5LxKBLB.BL1K-LxK-LB-qLB.zt");
		start.addCookie("SUB", "_2A251Nr0VDeTxGeNN7lsV8i7PzzyIHXVWRandrDV8PUNbmtANLUjAkW8crQKcleaTrsexqHmTKNAmj3R3dw..");		
		
		start.addHeader("Host", "weibo.cn");
		start.addHeader("Upgrade-Insecure-Requests", "1");
		start.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		start.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		start.addHeader("Cache-Control", "no-cache, must-revalidate");
		start.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		start.addHeader("Connection", "keep-alive");
		start.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
		GeccoEngine.create()
		.classpath("com.sina.spider")
		.start(start)
		.interval(5000)
		.run();
	}
	
}
