package com.sipder.sina;


import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="http://weibo.cn/{userID}", pipelines = {"consolePipeline", "SaveArticlePipeline"})
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

	public  void Spidermain() {
		System.out.println("invoke spider program");
		HttpGetRequest start = new HttpGetRequest("http://weibo.cn/fbb0916");
		start.addCookie("SCF", "Ap_YjAYZCLPj9tUybsLDEICX2T8pgKDzgowDX1aQQW20lCUUA6BCX645WHRwC_CQ5OMKwbqLq96QT-t5baFa8WY.");
		start.addCookie("ALF", "1510486488");
		start.addCookie("tgc", "TGT-NjA0MDg4OTMxMw==-1478950488-xd-5294D78EC92CDD43A63A2AFD9C28B7A5");
		start.addCookie("LT", "1478950488");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFycG19Fy2-Mz1mOyGnZfKY5NHD95QcehB71hn4e020Ws4Dqcjs9rD4qJSr");
		start.addCookie("ALC", "ac%3D2%26bt%3D1478950488%26cv%3D5.0%26et%3D1510486488%26scf%3D%26uid%3D6040889313%26vf%3D0%26vs%3D0%26vt%3D0%26es%3Ddd83299ca8ececa149836be31a88eeb9");
		start.addCookie("sso_info", "v02m6alo5qztaaep6WimLacpp2WpaSPk5iwjYOAuI6DpLOMk4zA");
		start.addCookie("SUB", "_2A251Io4IDeTxGeBO71IZ-CfPyj-IHXVWWfjArDV_PUNbm9AKLVKikW92Br9FFupH1gmOhJjkJvan6yAlvQ..");
		
		start.addHeader("Host", "weibo.cn");
		start.addHeader("Upgrade-Insecure-Requests", "1");
		start.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		start.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		start.addHeader("Cache-Control", "no-cache, must-revalidate");
		start.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		start.addHeader("Connection", "keep-alive");
		start.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
		GeccoEngine.create()
		.classpath("com.spider.sina")
		.start(start)
		.interval(5000)
		.run();
	}
	
}
