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
		start.addCookie("SCF", "AgVo8M3RqRxfLJPMEnPFBWaX-hInd-Oc17LeZJil5DVyNwOUF-vsN8U6xpIOsQwyTZwNSlw9AzqkOQZOcSLqNkE.");
		start.addCookie("ALF", "1510820581");
		start.addCookie("tgc", "TGT-NjA0MDg4OTMxMw==-1479284581-xd-EB83BFC778A70C236BE2C2AE06EC1B69");
		start.addCookie("LT", "1479284581");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFycG19Fy2-Mz1mOyGnZfKY5NHD95QcehB71hn4e020Ws4Dqcjs9rD4qJSr");
		start.addCookie("ALC", "ac%3D2%26bt%3D1479284581%26cv%3D5.0%26et%3D1510820581%26scf%3D%26uid%3D6040889313%26vf%3D0%26vs%3D0%26vt%3D0%26es%3D6b956dd381287cee682e49d0266c50c0");
		start.addCookie("sso_info", "v02m6alo5qztaaep6WimLacpp2WpaSPk5iwjYOAuI6DpLOMk4zA");
		start.addCookie("SUB", "_2A251KGc1DeTxGeBO71IZ-CfPyj-IHXVWXN_9rDV_PUNbm9AKLU3ZkW8jowwEXNIg2YCB-3CS0HFEYjTLhw..");		
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
