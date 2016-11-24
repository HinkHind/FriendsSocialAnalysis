package com.zhihu.spider;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

@PipelineName("SavePeoplePipeline")
public class SavePeoplePipeline  implements Pipeline<peopleList>{
	private static final int ANSWE_RNUM_PAGE = 20;
	private static final String BaicUrl = "https://www.zhihu.com/people/";

	@Override
	public void process(peopleList peoplelist) {
		HttpRequest currRequest = peoplelist.getRequest();
	
		int totalNum = peoplelist.getTotalAnswerNum();
		int currPage = peoplelist.getCurrPage();
		ArrayList<Iterm> iterms = peoplelist.getIterms();
		for(Iterm iterm:iterms) {
			//System.out.println(iterm.getAnswerTime());
			System.out.println(Utils.getDate(iterm.getAnswerTime()));
			
		}
		if(currPage * ANSWE_RNUM_PAGE < totalNum) {
			int nextPage = currPage + 1;
			String nextPageUrl = BaicUrl + peoplelist.getUserName()+"/answers?page="+nextPage;
			System.out.println(nextPageUrl);
			SchedulerContext.into(currRequest.subRequest(nextPageUrl));
		}
		
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
