package com.sina.spider.comment;

import java.io.StringReader;
import java.util.ArrayList;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.sina.spider.articleList;

@Gecco(matchUrl="http://weibo.cn/comment/{weiboID}?uid={uID}", pipelines="consolePipeline")
public class commentList implements HtmlBean{

	private static final long serialVersionUID = 1918214094413947446L;
	
	@RequestParameter
	private String weiboID;
	
	@RequestParameter
	private String uID;
	
	@Request
	private HttpRequest request;
	

	@HtmlField(cssPath="div.c[id^=C_]")
	private ArrayList<Commentor> coms;

	public String getWeiboID() {
		return weiboID;
	}

	public String getuID() {
		return uID;
	}

	public HttpRequest getRequest() {
		return request;
	}



	public void setWeiboID(String weiboID) {
		this.weiboID = weiboID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}


	public ArrayList<Commentor> getComs() {
		return coms;
	}

	public void setComs(ArrayList<Commentor> coms) {
		this.coms = coms;
	}

	public void Start(String startUrl) {
		HttpGetRequest start = new HttpGetRequest(startUrl);
		start.addCookie("SCF", "AkVbqwBAzH-O9MZr9ZgkOIT-oZzWczAKKPDS4PhfG_j_uMZ2WCPVfFn8VFKCkr8nya5GmYW3dRGYMz2yvhPl_PY.");
		start.addCookie("ALF", "1511875925");
		start.addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFycG19Fy2-Mz1mOyGnZfKY5NHD95QcehB71hn4e020Ws4Dqcjs9rD4qJSr");
		start.addCookie("SUB", "_2A251OEGFDeTxGeBO71IZ-CfPyj-IHXVWTDRNrDV_PUNbm9AKLWzfkW9K_MgIjcYRt7MB-JD59TUmlGyK0Q..");		
		
		start.addHeader("Host", "weibo.cn");
		start.addHeader("Upgrade-Insecure-Requests", "1");
		start.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		start.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		start.addHeader("Cache-Control", "no-cache, must-revalidate");
		start.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		start.addHeader("Connection", "keep-alive");
		start.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
		GeccoEngine.create()
		.classpath("com.sina.spider.comment")
		.start(start)
		.interval(5000)
		.run();
	}
	public static void main(String args[]) {
		articleList Spidermain = new articleList();
		Spidermain.Start("http://weibo.cn/comment/EiC0nCymq?uid=1749127163");
	}

}
