package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sipder.sina.articleList;

import hibernateDao.Dao;
import hibernateMapping.*;
import hibernateUtil.*;

public class EnterIndex extends ActionSupport{
	
	private Set friends;
	 
	private Set selectedEntries;
	private Integer friendId;
	private String selectedPlatform;
	
	public String getSelectedPlatform() {
		return selectedPlatform;
	}

	public void setSelectedPlatform(String selectedPlatform) {
		this.selectedPlatform = selectedPlatform;
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

	public Set getSelectedEntries() {
		return selectedEntries;
	}

	public void setSelectedEntries(Set selectedEntries) {
		this.selectedEntries = selectedEntries;
	}

	public static String enterIndexInitially() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		context.getSession().put("selectedPlatform", "weibo");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, userId);
		
		String sqlQuery = "select * from friend where userID = :userId limit 1";
		List qList = session.createSQLQuery(sqlQuery)
				.addScalar("friendID", StandardBasicTypes.INTEGER)
				.setInteger("userId", new Integer(userId))
				.list();
		//System.out.println(qList);	
		
		
		if (qList.isEmpty()) {
			context.getSession().put("friendId", 0);
		} else {
			Integer friendIDInteger = (Integer) qList.get(0);
			context.getSession().put("friendId", friendIDInteger.intValue());
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
		//loadIndexData();
		return SUCCESS;
	}
	
	public String loadIndexData() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		System.out.println("before art");
		articleList art = new articleList();
		art.Spidermain();
		System.out.println("after art");
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
				if (friend.isHasWeibo()) {
					
					setSelectedEntries(friend.getWeiboUrl().getWeiboEntries());
				} else {
					setSelectedEntries(new HashSet(0));
				}
				break;
			case "zhihu":
				if (friend.isHasZhihu()) {
					setSelectedEntries(friend.getZhihuUrl().getZhihuEntries());
				} else {
					setSelectedEntries(new HashSet(0));
				}
				
				break;
			case "csdn":
				if (friend.isHasCsdn()) {
					setSelectedEntries(friend.getCsdnUrl().getCsdnEntries());
				} else {
					setSelectedEntries(new HashSet(0));
				}
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
		//loadIndexData();
		return SUCCESS;
	}
	
	public String enterIndexWithSelectedPlatform() {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("selectedPlatform", selectedPlatform);
		//loadIndexData();
		return SUCCESS;
	}
	
	public String enterIndex() {
		loadIndexData();
		return SUCCESS;
	}
}
