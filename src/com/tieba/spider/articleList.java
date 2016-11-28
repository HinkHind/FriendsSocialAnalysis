package com.tieba.spider;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="http://tieba.baidu.com/f?kw={tiebaName}&ie=utf-8&pn={indexNum}", pipelines="consolePipeline")
public class articleList implements HtmlBean{

	private static final long serialVersionUID = -2810276957572190343L;
	
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String tiebaName;
	
	@RequestParameter
	private int indexNum;
		
	@HtmlField(cssPath="body")
	private String titleUrls;
	
//	@Href
//	@HtmlField(cssPath="#thread_list > li:nth-child(2) > div > div.col2_right.j_threadlist_li_right > div.threadlist_lz.clearfix > div.threadlist_title.pull_left.j_th_tit > a")
//	private String  Iterms;



	public HttpRequest getRequest() {
		return request;
	}

	public String getTitleUrls() {
		return titleUrls;
	}

	public void setTitleUrls(String titleUrls) {
		this.titleUrls = titleUrls;
	}

	public String getTiebaName() {
		return tiebaName;
	}

	public int getIndexNum() {
		return indexNum;
	}


	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public void setTiebaName(String tiebaName) {
		this.tiebaName = tiebaName;
	}

	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}

	
//	public String getIterms() {
//		return Iterms;
//	}
//
//	public void setIterms(String iterms) {
//		Iterms = iterms;
//	}

	public void Start(String startUrl) {
		HttpGetRequest start = new HttpGetRequest(startUrl);
		start.addHeader("Cookie", "userFromPsNeedShowTab=1; BAIDUID=70CFB7D95D63C18227142D74860B266E:FG=1; BIDUPSID=30D0509FAEF8A3839316B72EEB9409EC; PSTM=1474426347; TIEBA_USERTYPE=4e35ce18ff49463130f61908; TIEBAUID=cb23caae14130a0d384a57f1; wise_device=0; bdshare_firstime=1479974771737");
		start.addHeader("Host", "tieba.baidu.com");
		start.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		start.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		start.addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		start.addHeader("Accept-Encoding","gzip, deflate");
		start.addHeader("Connection","keep-alive");
		start.addHeader("Upgrade-Insecure-Requests","1");
		start.addHeader("Cache-Control","max-age=0");
		GeccoEngine.create()
		.classpath("com.tieba.spider")
		.start(start)
		.interval(5000)
		.run();
	}
	public static void  main(String args[]) {
		articleList arList  = new articleList();
//		ppList.Start("https://www.zhihu.com/people/xiaolunzi/answers?page=1");
//		ppList.Start("https://www.zhihu.com/people/leng-qian-17-51/answers?page=1");
		arList.Start("http://tieba.baidu.com/f?kw=%E5%93%88%E5%B0%94%E6%BB%A8%E5%B7%A5%E4%B8%9A%E5%A4%A7%E5%AD%A6&ie=utf-8&pn=0");
		
	}
	
	

}
