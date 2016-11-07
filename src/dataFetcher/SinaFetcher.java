package dataFetcher;

import org.hibernate.Transaction;

import hibernateMapping.WeiboEntry;
import hibernateMapping.WeiboUrl;

import java.util.List;

import org.hibernate.Session;

import hibernateUtil.HibernateUtil;

public class SinaFetcher extends Fetcher {
	public void fetchEntry() {
		
		/*
		 * weibo_entry Database:
		 * entryID, weiboID, entryUrl, text, likeNumber, shareNumber, commentNumber, sourceDevice, isShared, originLikeNumber, originShareNumber, originText, originCommentNumber, publishedTime, hasRead, classHolder

			contentHolder部分替换成如下内容：
			
			entryUrl			//条目的url，我好像找到了一种办法
			text				//博主自己说的话，非转发微博中是博主自己说的话，转发微博中是转发理由
			likeNumber			//本条微博赞数
			shareNumber			//本条微博转发数
			commentNumber		//评论数
			sourceDevice		//来源设备（小米手机啦之类的）
			
			isShared			//bool变量，是否是转发微博
			//本条待定 shareSourceUrl		//转发的微博的发布者（如范冰冰工作室）
			originLikeNumber	//转发的微博原本的赞数
			originShareNumber	//转发的微博的被转发数
			originText			//转发的微博的内容
			originCommentNumber	//转发的微博的评论数
		 * 
		 */
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		//entryID, weiboID, entryUrl, text, likeNumber, shareNumber, commentNumber, sourceDevice, isShared, originLikeNumber, originShareNumber, originText, originCommentNumber, publishedTime, hasRead, classHolder
		
		WeiboEntry weiboEntry = new WeiboEntry();
		//entryID 不用设置，自动设置
		
		//weiboUrl是weiboEntry对应的weibo账号的weiboUrl对象的引用，这里不用weiboID
		weiboEntry.setWeiboUrl(weiboUrl);
		//欲获取weiboUrl的引用，如果你有weiboID，可如下做：
		WeiboUrl weiboUrl = (WeiboUrl) session.get(WeiboUrl.class, weiboID)
		//如果你有微博地址，要查询，则如下做
		String sqlString = "select * from weiboUrl where weiboUrl = :weiboUrl limit 1";
		List wList = session.createSQLQuery(sqlString)
				.addEntity(WeiboUrl.class)
				.setString("weiboUrl", "你的微博url")//设置变量
				.list();
		weiboUrl = (WeiboUrl) wList.get(0);
		
		//设置之后的各项
		weiboEntry.setEntryUrl(entryUrl);
		
		//省略直到isShared
		
		if (如果这条微博是转发微博) {
			weiboEntry.setIsShared(true);
			//接着设置下面的项
			//originLikeNumber, originShareNumber, originText, originCommentNumber, 
			
			
		}
		
		//设置下面的项，其中classHolder是为分类（运动啦，武术啦）预留的，可不设置
		//publishedTime, hasRead, classHolder
		
		
		//最后保存
		session.save(weiboEntry);
		
		//下面这两句话也一定要有
		transaction.commit();
		HibernateUtil.closeSession();
		
	}
}
