package com.sipder.sina;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;



@PipelineName("SaveArticlePipeline")
public class SaveArticlePipeline implements Pipeline<articleList>{
	
	@Override
	public void process(articleList articlelist) {
		HttpRequest currRequest = articlelist.getRequest();
		
		System.out.println(getTotalNum(articlelist.getWeiboNum()));
		System.out.println(articlelist.getFollowing());
		System.out.println(getUserID(articlelist.getFollowing()));
		
		Document contentDoc = Jsoup.parseBodyFragment(articlelist.getContent());
		List<Element> weiboItems = getGoalContent(contentDoc); //得到没篇微博的结点
		
		// 微博数量超过限制，过滤掉，使其拿不到后续链接自动结束
		if(weiboItems == null){
			//contentDoc = new Document("");
			System.out.println("微博数量过多，暂不拿取");
		}
		
//		if(weiboItems != null && weiboItems.size() > 0){
//			createFile(weiboItems);
//		}
		Element pageEl = contentDoc.getElementById("pagelist");
		
		if(pageEl != null){
			List<Element> hrefEls = pageEl.getElementsByTag("a");
			for(Element el: hrefEls){
				if(el.toString().contains("下页")){
					String nextPageUrl = "http://weibo.cn" + el.attr("href");
					SchedulerContext.into(currRequest.subRequest(nextPageUrl));
					//WeiboUrlQueue.addElement("http://weibo.cn" + el.attr("href").split("&gsid=")[0]); 
					break;
				}
			}
			System.out.println(">> progress of current user: " + pageEl.text());
		}
		
	}

//	// 将抓取的微博信息保存至本地文件
// 	public static void createFile(List<Element> weiboItems) {
//		//String userID = Utils.getUserIdFromUrl(urlPath);
// 		for(Element el: weiboItems){				
//			Weibo weibo = parse(el);
//			System.out.println(weibo.toString());
// 		}
//
//	}

// // 解析微博的HTML DIV结构，提取微博ID、内容等信息，创建Weibo对象
// 	public static Weibo parse(Element weiboEl){
// 		Weibo weibo = new Weibo();
// 		List<Element> subDivs =  weiboEl.children();
// 		
// 		try {
// 			int subDivsSize = subDivs.size();
// 			weibo.setId(weiboEl.attr("id").substring(2));
// 			//weibo.setPoster(poster);
// 			weibo.setPostTime(Utils.parseDate(weiboEl.getElementsByClass("ct").get(0).text().split("来自")[0]));
// 			
// 			if(subDivsSize == 1){
// 				// 原创发布无附件微博
// 				weibo.setRepost(false);
// 				weibo.setHasPic(false);
// 				weibo.setContent(weiboEl.getElementsByClass("ctt").get(0).text());
// 			}
// 			else if(subDivsSize == 2){
// 				if(subDivs.get(0).toString().contains("<span class=\"cmt\">原文转发")){
// 					// 转发无附件微博
// 					weibo.setRepost(true);
// 					weibo.setHasPic(false);
// 					weibo.setContent(getRepostReason(subDivs.get(1)));
// 				}
// 				else{
// 					// 原创发布带附件微博
// 					weibo.setRepost(false);
// 					weibo.setHasPic(true);
// 					weibo.setContent(weiboEl.getElementsByClass("ctt").get(0).text());
// 				}
// 			}
// 			else if(subDivsSize == 3){
// 				// 转发带附件的微博
// 				weibo.setRepost(true);
// 				weibo.setHasPic(true);
// 				weibo.setContent(getRepostReason(subDivs.get(2)));
// 			}
// 			else{
// 				throw new Exception();
// 			}
// 		}
// 		catch(Exception e){
// 			weibo = null;
// 			//Log.error(e);
// 			//.error("Not a valid weibo item: " + weiboEl);
// 			System.out.println(e);
// 			System.out.println("Not a valid weibo item: " + weiboEl);
// 		}
// 		
// 		return weibo;
// 	}

 // 从子div中获取转发原因
 	private static String getRepostReason(Element processEl){
 		StringBuilder repostReason = new StringBuilder();
 		int endIndex = processEl.childNodes().size() - 9;
 		
 		for(int i = 1; i < endIndex; i++){
 			repostReason.append(processEl.childNode(i).toString());
 		}
 		
 		return repostReason.toString();
 	}
 	
 	/**
 	 * 获取某人微博总数量
 	 * @param articlelist.getWeiboNum
 	 * @return
 	 */
 	public static int getTotalNum(String str) {

		int startIndex = str.indexOf("[");
		int endIndex = str.indexOf("]");
		int weiboNum = Integer.parseInt(str.substring(startIndex + 1, endIndex));
		return weiboNum;
 	}
 	public static String getUserID(String str) {
 		int startIndex = str.indexOf("cn/");
		int endIndex = str.indexOf("/follow");
		String userID = str.substring(startIndex + 3, endIndex);
		return userID;
 	}
 	/**
 	 * 返回微博结点
 	 * @param doc
 	 * @return
 	 */
	public static List<Element> getGoalContent(Document doc) {
		List<Element> weiboItems = new ArrayList<Element>();	
		// 检查是否包含微博节点
		Elements elements = doc.getElementsByClass("c");
		for(Element el: elements){
			if(el.id().startsWith("M_")){
				weiboItems.add(el);
			}
		}	
		return weiboItems;
	}
	
	
}

