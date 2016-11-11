package controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import hibernateMapping.*;
import hibernateMapping.WeiboEntry;
import hibernateMapping.WeiboUrl;
import hibernateMapping.ZhihuEntry;
import hibernateUtil.HibernateUtil;

public class Test  extends ActionSupport{
	private String entryStr;
	private String selectedPlat;
	//private String weiboEntryStr;
//	private int friendId;
//	
//	
//	
//	public int getFriendId() {
//		return friendId;
//	}
//
//
//	public void setFriendId(int friendId) {
//		this.friendId = friendId;
//	}

	public String getEntryStr() {
		return entryStr;
	}

	public void setEntryStr(String entryStr) {
		this.entryStr = entryStr;
	}
	
	public String getSelectedPlat() {
		return selectedPlat;
	}

	public void setSelectedPlat(String selectedPlat) {
		this.selectedPlat = selectedPlat;
	}

	public String addEntry() {
		System.out.println(selectedPlat);
		switch (selectedPlat) {
		case "weibo":
			addWeiboEntry();
			break;
		case "zhihu":
			addZhihuEntry();
		default:
			break;
		}
		
		return SUCCESS;
	}
	
	public String addWeiboEntry() {
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		ActionContext context = ActionContext.getContext();
		
		int friendId = (int)context.getSession().get("friendId");
		
		Friend friend = (Friend) session.get(Friend.class, friendId);
		WeiboUrl weiboUrl = friend.getWeiboUrl();
		WeiboEntry weiboEntry = new WeiboEntry(weiboUrl, "ttt", getEntryStr(), 5, 3, 9, "7", false, 1,1, "tt",1, new Date(), false, "t");
		session.save(weiboEntry);
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}


	public String addZhihuEntry() {
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		ActionContext context = ActionContext.getContext();
		
		int friendId = (int)context.getSession().get("friendId");
		
		Friend friend = (Friend) session.get(Friend.class, friendId);
		ZhihuUrl zhihuUrl = friend.getZhihuUrl();
		ZhihuEntry zhihuEntry = new ZhihuEntry(zhihuUrl,getEntryStr(), new Date(), false, "f");
		session.save(zhihuEntry);
//		
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}
}
