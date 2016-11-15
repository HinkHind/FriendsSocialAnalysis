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
		//start.addCookie("SUV", "1460541527037365");
		start.addCookie("SCF", "Av60dCyfGU1Q9RnKxax3RhfZmHsZQIt2mdjjShIMSZLYHaTWhn-6lTLAPQodOCNF4qGONLgqzrxNfJM8z00qImg.");
		start.addCookie("ALF", "1510710161");
		start.addCookie("tgc", "TGT-NjA0MDg4OTMxMw==-1479174161-ja-106D16C6D6A01DF581A353DA214051F3");
		start.addCookie("LT", "1479174161");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFycG19Fy2-Mz1mOyGnZfKY5NHD95QcehB71hn4e020Ws4Dqcjs9rD4qJSr");
		start.addCookie("ALC", "ac%3D2%26bt%3D1479174161%26cv%3D5.0%26et%3D1510710161%26scf%3D%26uid%3D6040889313%26vf%3D0%26vs%3D0%26vt%3D0%26es%3D760bcf7c3967ed49442b94cec2f2c113");
		start.addCookie("sso_info", "v02m6alo5qztaaep6WimLacpp2WpaSPk5iwjYOAuI6DpLOMk4zA");
		start.addCookie("SUB", "_2A251LhhBDeTxGeBO71IZ-CfPyj-IHXVWWg6JrDV_PUNbm9ANLVf9kW-dgOfJ83Jq5KXCXpJ7TqfLEqRjIA..");		
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
