package com.sina.spider;

import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;

import java.util.ArrayList;


import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.sina.spider.model.WeiboUrl;
import com.sina.spider.utils.DownloadSQL;
import com.sina.spider.utils.UploadSQL;


public class spider {
	public static void umain(String args[]) {
		ArrayList<WeiboUrl> wblist = new ArrayList<>();
		DownloadSQL down = new DownloadSQL();
		while(true) {
			
			wblist = down.getNewWeiboUrl(); 
			
			if(wblist.size()==0) {
				try {
					Thread.sleep(1*30*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("新URL的数量："+wblist.size());
				for(int i=0; i<wblist.size();i++) {
					String startWeiUrl = wblist.get(i).getWeiboUrl();
					System.out.println("第一个URL"+startWeiUrl);
					HttpGetRequest start = new HttpGetRequest(startWeiUrl);
					
					articleList Spidermain = new articleList();
					Spidermain.Start(startWeiUrl);
					
					
//					UploadSQL up = new UploadSQL();
//					up.updateWeiboNew(wblist.get(i).getWeiboID());
				}
				
			}
			
		}
		
		
	}
	public static void main(String args[]) {
		articleList Spidermain = new articleList();
		Spidermain.Start("http://weibo.cn/fbb0916");
	}
	
	
	
}
