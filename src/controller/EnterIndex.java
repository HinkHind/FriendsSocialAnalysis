package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateDao.Dao;
import hibernateMapping.*;
import hibernateUtil.*;

public class EnterIndex extends ActionSupport{
	
	private Set friends;
	 
	private Set weiboEntries;
	private Set zhihuEntries;
	private Set csdnEntries;
	private Set selectedEntries;
	
	public Set getSelectedEntries() {
		return selectedEntries;
	}


	public void setSelectedEntries(Set selectedEntries) {
		this.selectedEntries = selectedEntries;
	}

	private Integer friendId;
	private String selectedPlatform;
	
	public String getSelectedPlatform() {
		return selectedPlatform;
	}


	public void setSelectedPlatform(String selectedPlatform) {
		this.selectedPlatform = selectedPlatform;
	}


	public Set getWeiboEntries() {
		return weiboEntries;
	}


	public void setWeiboEntries(Set weiboEntries) {
		this.weiboEntries = weiboEntries;
	}


	public Set getZhihuEntries() {
		return zhihuEntries;
	}


	public void setZhihuEntries(Set zhihuEntries) {
		this.zhihuEntries = zhihuEntries;
	}


	public Set getCsdnEntries() {
		return csdnEntries;
	}


	public void setCsdnEntries(Set csdnEntries) {
		this.csdnEntries = csdnEntries;
	}

	
	
	

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






//	public String enterIndex() {
//		ActionContext context = ActionContext.getContext();
//		int userID = (int) context.getSession().get("userID");
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		User user = (User) session.get(User.class, userID);
//		setFriends(user.getFriends());
//		
//		Iterator iterator = friends.iterator();
//		if (iterator.hasNext()) {
//			Friend friend = (Friend) iterator.next();
//			WeiboUrl weiboUrl = friend.getWeiboUrl();
//			setSelectedEntries(weiboUrl.getWeiboEntries());
//			//System.out.println(weiboEntries);
//		} else {
//			setSelectedEntries(new HashSet(0));
//		}
//		
//		tx.commit();
//		HibernateUtil.closeSession();
//		
//		return SUCCESS;
//	}
	
	public String enterIndexInitially() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		context.getSession().put("selectedPlatform", "weibo");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, userId);
		
		Iterator iterator = user.getFriends().iterator();
		if (iterator.hasNext()) {
			Friend friend = (Friend) iterator.next();
			context.getSession().put("friendId", friend.getFriendId().intValue());
			
		} else {
			context.getSession().put("friendId", 0);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
		loadIndexData();
		return SUCCESS;
	}
	
	public String loadIndexData() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		
		//set friends;
		setFriends(user.getFriends());
		
		int friendId = (int) context.getSession().get("friendId");
		
		//set selectedEntries;
		if (friendId == 0) {
			setSelectedEntries(new HashSet(0));
		} else {
			Friend friend = (Friend) session.get(Friend.class, friendId);
			String selectedPlat = (String)context.getSession().get("selectedPlatform");
			switch (selectedPlat) {
			case "weibo":
				//TODO: need thinking about hasWeibo = false condition.
				setSelectedEntries(friend.getWeiboUrl().getWeiboEntries());
				break;
			case "zhihu":
				setSelectedEntries(friend.getZhihuUrl().getZhihuEntries());
				break;
			case "csdn":
				setSelectedEntries(friend.getCsdnUrl().getCsdnEntries());
				break;
			default:
				break;
			}
			
		}
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
//	public String enterIndexWithSelectedFriend() {
//		//System.out.println(friendId);
//		ActionContext context = ActionContext.getContext();
//		int userID = (int) context.getSession().get("userID");
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		
//		User user = (User) session.get(User.class, userID);
//		
//		setFriends(user.getFriends());
//		
//		Friend friend = (Friend) session.get(Friend.class, friendId.intValue());
//		WeiboUrl weiboUrl = friend.getWeiboUrl();
//		setWeiboEntries(weiboUrl.getWeiboEntries());
//		
//		tx.commit();
//		HibernateUtil.closeSession();
//		return SUCCESS;
//	}
	public String enterIndexWithSelectedFriend() {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("friendId", friendId.intValue());
		loadIndexData();
		return SUCCESS;
	}
	
	public String enterIndexWithSelectedPlatform() {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("selectedPlatform", selectedPlatform);
		loadIndexData();
		return SUCCESS;
	}
	
	public String enterIndex() {
		loadIndexData();
		return SUCCESS;
	}
}
