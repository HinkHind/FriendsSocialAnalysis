package controller;

import java.util.List;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateDao.Dao;
import hibernateMapping.Friend;
import hibernateMapping.User;
import hibernateMapping.WeiboUrl;
import hibernateUtil.HibernateUtil;

public class ManageFriend extends ActionSupport{
	
	private String friendName;
	private String weiboUrlStr;
	private String csdnUrl;
	private Set friends;
	private int friendId;
	
	
	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}
	
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	
	
	
	public String getWeiboUrlStr() {
		return weiboUrlStr;
	}

	public void setWeiboUrlStr(String weiboUrlStr) {
		this.weiboUrlStr = weiboUrlStr;
	}

	public String getCsdnUrl() {
		return csdnUrl;
	}
	
	public void setCsdnUrl(String csdnUrl) {
		this.csdnUrl = csdnUrl;
	}
	
	
	public Set getFriends() {
		return friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}

	public String addFriend() {
		Friend friend = new Friend();
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
//		User user = Dao.getUser(userID);
//		friend.setUser(user);
//		friend.setFriendName(friendName);
//		Dao.saveFriend(friend);
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		friend.setUser(user);
		friend.setFriendName(getFriendName());
		session.save(friend);
		
		//setFriends(user.getFriends());
		transaction.commit();
		
		//System.out.println(getFriends());
		HibernateUtil.closeSession();
		
		Session session2 = HibernateUtil.currentSession();
		Transaction transaction2 = session2.beginTransaction();
		
		user = (User)session2.get(User.class, userId);
		setFriends(user.getFriends());
		transaction2.commit();
		HibernateUtil.closeSession();
		
		
		//enterControl();
		return SUCCESS;
	}
	
	public String loadControlData() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		
		setFriends(user.getFriends());
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
		
	}
	
	
	
	public String removeWeiboUrl() {
		
		System.out.println(friendId);
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
		if (friend.isHasWeibo()) {
			
			WeiboUrl weiboUrl = friend.getWeiboUrl();
			weiboUrl.setCount(weiboUrl.getCount() - 1);
			if (weiboUrl.getCount() <= 0) {
				//cascade at weibo_entries is executed!
				session.delete(weiboUrl);
			} else {
				session.save(weiboUrl);
			}
			
			friend.setWeiboUrl(null);
			friend.setHasWeibo(false);
			session.save(friend);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
		
		
		return SUCCESS;
	}
	
	
	public String addWeiboUrl() {
		
		
		//ActionContext context = ActionContext.getContext();
		//int userID = (int) context.getSession().get("userID");
		//User user = Dao.getUser(userID);
		//System.out.println(friendId);
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
		String sqlQuery = "select * from weibo_url where weiboUrl = :weiboUrl limit 1";
		
		List queryList = session.createSQLQuery(sqlQuery)
				.addEntity(WeiboUrl.class)
				.setString("weiboUrl", weiboUrlStr)
				.list();
		
		
		friend.setHasWeibo(true);
		WeiboUrl weiboUrlObj = Dao.saveWeiboUrl(weiboUrl);
		friend.setWeiboUrl(weiboUrlObj);
		
		return SUCCESS;
	}
}
