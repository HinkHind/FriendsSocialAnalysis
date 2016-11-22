package com.zhihu.spider;

import java.util.ArrayList;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="https://www.zhihu.com/people/{userName}/answers", pipelines = "consolePipeline")
//@Gecco(matchUrl="https://www.zhihu.com/people/{userName}/answers", pipelines = {"consolePipeline", "SavePeoplePipeline"})
public class peopleList implements HtmlBean {

	private static final long serialVersionUID = -1667122202814191660L;
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String userName;
	
//	@Text
//	@HtmlField(cssPath="body > div.zg-wrap.zu-main.clearfix > div.zu-main-content > div > div.zm-profile-header.ProfileCard > div.zm-profile-header-main > div > div.top > div.title-section > span")
//	private String name;
	
	@Text
	@HtmlField(cssPath="body > div.zg-wrap.zu-main.clearfix > div.zu-main-content > div > div.zm-profile-header.ProfileCard > div.zm-profile-header-main > div > div.top > div.title-section > div")
	private String description;
	
	@HtmlField(cssPath="#zh-profile-answer-list > div")
	private ArrayList<Iterm> iterms;
	
	
//	@HtmlField(cssPath="#zh-profile-answer-list-outer > div.border-pager > div")
//	private String PageInfo;
//	
//	@Text
//	@HtmlField(cssPath="#zh-profile-answer-list-outer > div.border-pager > div > span.zg-gray-normal")
//	private int CurrPage;
	
//	public int getCurrPage() {
//		return CurrPage;
//	}
//	public void setCurrPage(int currPage) {
//		CurrPage = currPage;
//	}
//	public String getPageInfo() {
//		return PageInfo;
//	}
//	public void setPageInfo(String pageInfo) {
//		PageInfo = pageInfo;
//	}
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
		start.addCookie("a_t", "2.0AGBAZ2SR0AoXAAAA6HJaWABgQGdkkdAKAGCAYDeqmQoXAAAAYQJVTehyWlgA66Cz5KyF8bsx4AAEQa1M-Zk9h3QZX9Fjep1Q-pLce2ZTBRDzZEukJw==");
		start.addCookie("z_c0", "Mi4wQUdCQVoyU1IwQW9BWUlCZ042cVpDaGNBQUFCaEFsVk42SEphV0FEcm9MUGtySVh4dXpIZ0FBUkJyVXo1bVQySGRB|1479730664|470042b435d6d5c3f14f8a83d3b0987791259c77");
		
		start.addHeader("Host", "www.zhihu.com");
		start.addHeader("Upgrade-Insecure-Requests", "1");
		start.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		start.addHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		//start.addHeader("Cache-Control", "no-cache, must-revalidate");
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
		ppList.Start("https://www.zhihu.com/people/qibaowonder/answers");
		
	}

}
