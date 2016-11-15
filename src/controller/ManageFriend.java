package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import hibernateDao.Dao;
import hibernateMapping.Friend;
import hibernateMapping.User;
import hibernateMapping.WeiboUrl;
import hibernateMapping.ZhihuUrl;
import hibernateUtil.HibernateUtil;

public class ManageFriend extends ActionSupport{
	
	private String friendName;
	private String weiboUrlStr;
	private String zhihuUrlStr;
	private String csdnUrl;
	private Set friends;
	private int friendId;
	private String selectedUrl;
	private String selectedPlat;
	
	private List<FriendWithData> friendsWithData =  new ArrayList<>();
	
	
	public String getZhihuUrlStr() {
		return zhihuUrlStr;
	}

	public void setZhihuUrlStr(String zhihuUrlStr) {
		this.zhihuUrlStr = zhihuUrlStr;
	}

	public List<FriendWithData> getFriendsWithData() {
		return friendsWithData;
	}

	public void setFriendsWithData(List<FriendWithData> friendsWithData) {
		this.friendsWithData = friendsWithData;
	}

	public String getSelectedPlat() {
		return selectedPlat;
	}

	public void setSelectedPlat(String selectedPlat) {
		this.selectedPlat = selectedPlat;
	}

	public String getSelectedUrl() {
		return selectedUrl;
	}

	public void setSelectedUrl(String selectedUrl) {
		this.selectedUrl = selectedUrl;
	}

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
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		friend.setUser(user);
		friend.setFriendName(getFriendName());
		session.save(friend);
		
		//setFriends(user.getFriends());
		transaction.commit();
		HibernateUtil.closeSession();
		System.out.println("friendId = " + friend.getFriendId());
		
		int friendId = (int) context.getSession().get("friendId");
		if (friendId == 0) {
			context.getSession().put("friendId", friend.getFriendId().intValue());
		}
		//System.out.println(getFriends());
//		HibernateUtil.closeSession();
//		
//		Session session2 = HibernateUtil.currentSession();
//		Transaction transaction2 = session2.beginTransaction();
//		
//		user = (User)session2.get(User.class, userId);
//		setFriends(user.getFriends());
//		transaction2.commit();
//		HibernateUtil.closeSession();
//		
		
		//enterControl();
		return SUCCESS;
	}
	
	public String loadFriendsData() {
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		setFriends(user.getFriends());
		System.out.println(new Exception().getStackTrace()[0].getMethodName() + " " + getFriends());
		
		for (Iterator iterator = getFriends().iterator(); iterator.hasNext();) {
			Friend friend = (Friend) iterator.next();
//			FriendWithData f = new FriendWithData(friend,
//					friend.getWeiboUrl().getWeiboUrl(),
//					friend.getZhihuUrl().getZhihuUrl(),
//					friend.getCsdnUrl().getCsdnUrl());
			
			
			FriendWithData f = new FriendWithData(friend);
			//System.out.println(f.getFriend().getFriendId());
			friendsWithData.add(f);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
		
	}
	
	
//	public String removeUrl() {
//		
//		switch (getSelectedPlat()) {
//		case "weibo":
//			removeWeiboUrl();
//			break;
//
//		default:
//			break;
//		}
//		
//		return SUCCESS;
//	}
	
	public String removeWeiboUrl() {
		
		//System.out.println(friendId);
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
	
	public String removeZhihuUrl() {
		
		//System.out.println(friendId);
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
		if (friend.isHasZhihu()) {
			
//			WeiboUrl weiboUrl = friend.getWeiboUrl();
//			weiboUrl.setCount(weiboUrl.getCount() - 1);
			ZhihuUrl zhihuUrl = friend.getZhihuUrl();
			zhihuUrl.setCount(zhihuUrl.getCount() - 1);
			
			
			if (zhihuUrl.getCount() <= 0) {
				//cascade at weibo_entries is executed!
				session.delete(zhihuUrl);
			} else {
				session.save(zhihuUrl);
			}
			
			friend.setZhihuUrl(null);
			friend.setHasZhihu(false);
			session.save(friend);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
		
		
		return SUCCESS;
	}
	
	
	/**
	 * suppose that the friend does not have weiboUrl (hasWeiboUrl = false;)
	 * @return
	 */
	public String addWeiboUrl() {
		int userId = Util.getUserIdFromSession();
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlString = "select * from weibo_url where weiboUrl = :weiboUrlStr limit 1";
		List qList = session.createSQLQuery(sqlString)
				.addEntity(WeiboUrl.class)
				.setString("weiboUrlStr",getWeiboUrlStr())
				.list();
		
		Friend friend = (Friend) session.get(Friend.class, getFriendId());
		
		WeiboUrl weiboUrl = null;
		if (qList.isEmpty()) {
			weiboUrl = new WeiboUrl();
			weiboUrl.setCount(1);
			weiboUrl.setWeiboUrl(getWeiboUrlStr());
			session.save(weiboUrl);
		} else {
			weiboUrl = (WeiboUrl) qList.get(0);
			weiboUrl.setCount(weiboUrl.getCount() + 1);
			session.save(weiboUrl);
		}
		
		friend.setHasWeibo(true);
		friend.setWeiboUrl(weiboUrl);
		session.save(friend);
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
	public String addZhihuUrl() {
		int userId = Util.getUserIdFromSession();
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlString = "select * from zhihu_url where zhihuUrl = :zhihuUrlStr limit 1";
		List qList = session.createSQLQuery(sqlString)
				.addEntity(ZhihuUrl.class)
				.setString("zhihuUrlStr",getZhihuUrlStr())
				.list();
		
		Friend friend = (Friend) session.get(Friend.class, getFriendId());
		
		//WeiboUrl weiboUrl = null;
		ZhihuUrl zhihuUrl = null;
		if (qList.isEmpty()) {
			zhihuUrl = new ZhihuUrl();
			zhihuUrl.setCount(1);
			zhihuUrl.setZhihuUrl(getZhihuUrlStr());
			session.save(zhihuUrl);
		} else {
			zhihuUrl = (ZhihuUrl) qList.get(0);
			zhihuUrl.setCount(zhihuUrl.getCount() + 1);
			session.save(zhihuUrl);
		}
		
		friend.setHasZhihu(true);
		friend.setZhihuUrl(zhihuUrl);
		session.save(friend);
		
		transaction.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
	
	public String updateWeiboUrl() {
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Friend friend = (Friend)session.get(Friend.class, friendId);
		
		transaction.commit();
		HibernateUtil.closeSession();
		
		
		if (getWeiboUrlStr() == friend.getWeiboUrl().getWeiboUrl()) {
			return SUCCESS;
		} else {
			if (friend.isHasWeibo()) {
				removeWeiboUrl();
			}
			addWeiboUrl();
			return SUCCESS;
		}
	}
	
	public String updateZhihuUrl() {
		
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Friend friend = (Friend)session.get(Friend.class, friendId);
		
		transaction.commit();
		HibernateUtil.closeSession();
		
		
		if (getZhihuUrlStr() == friend.getZhihuUrl().getZhihuUrl()) {
			return SUCCESS;
		} else {
			if (friend.isHasWeibo()) {
				removeZhihuUrl();
			}
			addZhihuUrl();
			return SUCCESS;
		}
	}
	
	
	
	public String displayUrl() {
		
		System.out.println(friendId);
		System.out.println(selectedPlat);
		Session session =  HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
		setSelectedUrl(friend.getWeiboUrl().getWeiboUrl());
		
		transaction.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}
	
	public String removeFriend() {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend)session.get(Friend.class, getFriendId());
		
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
		//TODO: the same for zhihu, csdn;
		session.delete(friend);
		
		
		
		
		System.out.println("remove friendId = " + friend.getFriendId().intValue());
		transaction.commit();
		HibernateUtil.closeSession();
		
		Session session2 = HibernateUtil.currentSession();
		Transaction transaction2 = session2.beginTransaction();
		
		ActionContext context = ActionContext.getContext();
		int userId = (int) context.getSession().get("userId");
		int friendId = (int)context.getSession().get("friendId");
		if (friend.getFriendId().intValue() == friendId) {
			String sqlQuery = "select * from friend where userID = :userId limit 1";
			List qList = session2.createSQLQuery(sqlQuery)
					.addScalar("friendID", StandardBasicTypes.INTEGER)
					.setInteger("userId", new Integer(userId))
					.list();
			//System.out.println(qList);	
			
			
			if (qList.isEmpty()) {
				context.getSession().put("friendId", 0);
				System.out.println("empty");
			} else {
				Integer friendIDInteger = (Integer) qList.get(0);
				context.getSession().put("friendId", friendIDInteger.intValue());
				System.out.println("remove friend change session friendId = "+friendIDInteger );
			}
		}
		
		
		transaction2.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}
	
	public String enterControl() {
		return SUCCESS;
	}
	
	public String displayFriends() {
		loadFriendsData();
		return SUCCESS;
	}
	
	public String editWeiboUrl() {
		return SUCCESS;
	}
	
	public String editZhihuUrl() {
		return SUCCESS;
	}
	
	
//	public String enterControlModal() {
//		return SUCCESS;
//	}
	
	
}

class FriendWithData{
	private Friend friend;
	private String weiboUrl;
	private String zhihuUrl;
	private String csdnUrl;
	
	public FriendWithData() {
		// TODO Auto-generated constructor stub
	}
	
	//need run in a Session.
	public FriendWithData(Friend friend) {
		super();
		this.friend = friend;
//		Session session = HibernateUtil.currentSession();
//		Transaction transaction = session.beginTransaction();
//		session.update(friend);
		this.weiboUrl = "";
		this.zhihuUrl = "";
		this.csdnUrl = "";
		if (friend.getCsdnUrl() != null) {
			this.csdnUrl = friend.getCsdnUrl().getCsdnUrl();
		}
		if (friend.getWeiboUrl() != null) {
			this.weiboUrl = friend.getWeiboUrl().getWeiboUrl();
		}
		if (friend.getZhihuUrl() != null) {
			this.zhihuUrl = friend.getZhihuUrl().getZhihuUrl();
		}
		
		
//		transaction.commit();
//		HibernateUtil.closeSession();
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public String getWeiboUrl() {
		return weiboUrl;
	}
	public void setWeiboUrl(String weiboUrl) {
		this.weiboUrl = weiboUrl;
	}
	public String getZhihuUrl() {
		return zhihuUrl;
	}
	public void setZhihuUrl(String zhihuUrl) {
		this.zhihuUrl = zhihuUrl;
	}
	public String getCsdnUrl() {
		return csdnUrl;
	}
	public void setCsdnUrl(String csdnUrl) {
		this.csdnUrl = csdnUrl;
	}
	
	
}

