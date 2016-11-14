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

@Gecco(matchUrl="http://weibo.cn/{userID}", pipelines = {"consolePipeline","SaveArticlePipeline"})
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
		start.addCookie("SCF", "AseYve14k4wnJGKX6-2kRh5LecxeS8dImCRbVqnUocsE3oJPq2y-q9S4tub8wjiGCi8qTV6FqGfBej3IuqyrPJU.");
		start.addCookie("ALF", "1510655558");
		start.addCookie("tgc", "TGT-NjA0MDg4OTMxMw==-1479119558-ja-5B73765D482338E188A001C1D3AD7785");
		start.addCookie("LT", "1479119558");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFycG19Fy2-Mz1mOyGnZfKY5NHD95QcehB71hn4e020Ws4Dqcjs9rD4qJSr");
		start.addCookie("ALC", "ac%3D2%26bt%3D1479119558%26cv%3D5.0%26et%3D1510655558%26scf%3D%26uid%3D6040889313%26vf%3D0%26vs%3D0%26vt%3D0%26es%3D6b92e7931f519bce81f397bb646fa571");
		start.addCookie("sso_info", "v02m6alo5qztaaep6WimLacpp2WpaSPk5iwjYOAuI6DpLOMk4zA");
		start.addCookie("SUB", "_2A251LeKWDeTxGeBO71IZ-CfPyj-IHXVWW1NerDV_PUNbm9ANLW-jkW8lyqm2pV3ykzrtzidMEsJLXNT9bA..");		
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
