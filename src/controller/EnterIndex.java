package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateDao.Dao;
import hibernateMapping.*;
import hibernateUtil.*;

public class EnterIndex extends ActionSupport{
	
	private Set friends;
	 
	private Set weiboEntrys;
	
	private Integer friendId;
	
	

	public Integer getFriendId() {
		return friendId;
	}


	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}


	public Set getFriends() {
		return friends;
	}


	public void setFriends(Set friends) {
		this.friends = friends;
	}


	public Set getWeiboEntrys() {
		return weiboEntrys;
	}


	public void setWeiboEntrys(Set weiboEntries) {
		this.weiboEntrys = weiboEntries;
	}




	public String enterIndex() {
		ActionContext context = ActionContext.getContext();
		int userID = (int) context.getSession().get("userID");
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, userID);
		setFriends(user.getFriends());
		
		Iterator iterator = friends.iterator();
		if (iterator.hasNext()) {
			Friend friend = (Friend) iterator.next();
			WeiboUrl weiboUrl = friend.getWeiboUrl();
			setWeiboEntrys(weiboUrl.getWeiboEntries());
			System.out.println(weiboEntrys);
		} else {
			weiboEntrys = new HashSet(0);
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}
	
	public String enterIndexWithSelectedFriend() {
		System.out.println(friendId);
		ActionContext context = ActionContext.getContext();
		int userID = (int) context.getSession().get("userID");
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		User user = (User) session.get(User.class, userID);
		
		setFriends(user.getFriends());
		
		Friend friend = (Friend) session.get(Friend.class, friendId.intValue());
		
		WeiboUrl weiboUrl = friend.getWeiboUrl();
		setWeiboEntrys(weiboUrl.getWeiboEntries());
		
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}
}
