package com.zhihu.spider;

import java.util.ArrayList;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

//@Gecco(matchUrl="https://www.zhihu.com/people/{userName}/answers?page={currPage}", pipelines = "consolePipeline")
@Gecco(matchUrl="https://www.zhihu.com/people/{userName}/answers?page={currPage}", pipelines =  "SavePeoplePipeline")
public class peopleList implements HtmlBean {

	private static final long serialVersionUID = -1667122202814191660L;
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String userName;
	
	@RequestParameter
	private int currPage;
	
	@Text
	@HtmlField(cssPath="body > div.zg-wrap.zu-main.clearfix > div.zu-main-content > div > div.zm-profile-header.ProfileCard > div.zm-profile-header-main > div > div.top > div.title-section > div")
	private String description;
	
	@HtmlField(cssPath="#zh-profile-answer-list > div")
	private ArrayList<Iterm> iterms;
	
	@Text
	@HtmlField(cssPath="body > div.zg-wrap.zu-main.clearfix > div.zu-main-content > div > div.zm-profile-header.ProfileCard > div.profile-navbar.clearfix > a.item.active > span")
	private int totalAnswerNum;
	
	
	public int getTotalAnswerNum() {
		return totalAnswerNum;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public void setTotalAnswerNum(int totalAnswerNum) {
		this.totalAnswerNum = totalAnswerNum;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<Iterm> getIterms() {
		return iterms;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIterms(ArrayList<Iterm> iterms) {
		this.iterms = iterms;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public String getUserName() {
		return userName;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void Start(String startUrl) {
		HttpGetRequest start = new HttpGetRequest(startUrl);
		start.addCookie("a_t", "2.0AGBAZ2SR0AoXAAAAZodfWABgQGdkkdAKAGCAYDeqmQoXAAAAYQJVTWSHX1gAYxzdtFJtnqDyYirqYf5Oy3KMeYP9R4Z7YFIICbHw7Mc5ULRuLWNxCg==");
		start.addCookie("z_c0", "Mi4wQUdCQVoyU1IwQW9BWUlCZ042cVpDaGNBQUFCaEFsVk5aSWRmV0FCakhOMjBVbTJlb1BKaUt1cGhfazdMY294NWd3|1480063590|021aba2c21f8cc751e4c2cac9966c4074fb2a0a0");
		start.addCookie( "_xsrf", "25c460258fcaedc5643ea0d601224cf1");
		start.addCookie( "login", "N2M5NWU1NDU4MDJhNDE5OGE3NGRhNjQwNTAxNDY5Nzk=|1480063588|8559b5755029481f1e062789ac37357f2cd339e0");
		start.addHeader("Host", "www.zhihu.com");
		start.addHeader("Upgrade-Insecure-Requests", "1");
		start.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		start.addHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		start.addHeader("Cache-Control", "max-age=0");
		start.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		start.addHeader("Connection", "keep-alive");
		start.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
		GeccoEngine.create()
		.classpath("com.zhihu.spider")
		.start(start)
		.interval(5000)
		.run();
	}
	public static void  main(String args[]) {
		peopleList ppList  = new peopleList();
//		ppList.Start("https://www.zhihu.com/people/xiaolunzi/answers?page=1");
//		ppList.Start("https://www.zhihu.com/people/leng-qian-17-51/answers?page=1");
		ppList.Start("https://www.zhihu.com/people/rafter/answers?page=1");
		
	}

}
