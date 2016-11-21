package com.sina.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sina.spider.model.Weibo;
import com.sina.spider.model.WeiboUrl;
import com.sina.spider.utils.DownloadSQL;
import com.sina.spider.utils.UploadSQL;
import com.sina.spider.utils.Utils;



public class spider {
	private static HabitAnalyzer  habitAnalyzer = new HabitAnalyzer();
	
	public static void umain(String args[]) throws IOException {
		ArrayList<WeiboUrl> wblist = new ArrayList<>();
		DownloadSQL down = new DownloadSQL();

		while(true) {
			
			wblist = down.getNewWeiboUrl(); 
			
			if(wblist.size()==0) {
				try {
					System.out.println("sleeping....");
					Thread.sleep(1*15*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("新URL的数量："+wblist.size());
				for(int i=0; i<wblist.size();i++) {
					String startWeiUrl = wblist.get(i).getWeiboUrl();
					System.out.println("第"+i+"个URL"+startWeiUrl);
					articleList Spidermain = new articleList();
					Spidermain.Start(startWeiUrl);					
					UploadSQL up = new UploadSQL();
					up.updateWeiboNew(wblist.get(i).getWeiboID());
					Weibo weibo = new Weibo();
					//DownloadSQL down = new DownloadSQL();
					ArrayList<Weibo> weibolist = down.getWeiboText();
					for(Weibo weibo2:weibolist) {
						List<String> eList = new LinkedList<String>();
						String text = Utils.deleteReason(weibo2.getText());
						eList = Utils.SplitText(text);
						Map<String, Integer> map = habitAnalyzer.analyzeEntry(eList);
						weibo2 = Utils.setInterestNum(weibo2,map);
						up.updateWeiboNum(weibo2);
					}
					//habitAnalyzer.analyzeEntry(entryWordList)
					
				}
				
			}
			
		}
		
		
	}
	public static void main(String args[]) {
		articleList Spidermain = new articleList();
		Spidermain.Start("http://weibo.cn/leijun");
	}
	 
	
	
}
