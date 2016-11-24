package com.zhihu.spider;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

@PipelineName("SavePeoplePipeline")
public class SavePeoplePipeline  implements Pipeline<peopleList>{


	@Override
	public void process(peopleList peopleList) {
//		HttpRequest currRequest = peopleList.getRequest();
//		//Document pageInfo = Jsoup.parseBodyFragment(peopleList.getPageInfo());
//		int totalPage = getTotalPage(pageInfo);
//		//int currPage = peopleList.getCurrPage();
//		if(currPage < totalPage) {
//			int nextPage = currPage + 1;
//			String nextPageUrl = "https://www.zhihu.com/people/"+peopleList.getUserName()+"/answers?page="+ nextPage;

		
		
	}
	
	//暂时只处理回答数量较多的情况，即回答的数量大于1页
	public int getTotalPage(Document doc) { 
		int page = 0; 
		List<Element> subSpan = doc.children();
		try {
			int size = subSpan.size();
			if(size>1) {
				String pageInfo = subSpan.get(size-1).text();
				page = Integer.parseInt(pageInfo);
			}
				
		}catch (Exception e) {
			
		}
		return page;
	}


}
