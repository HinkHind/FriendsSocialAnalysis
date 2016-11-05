package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateDao.Dao;
import hibernateMapping.Friend;
import hibernateMapping.User;
import hibernateMapping.WeiboUrl;

public class AddFriend extends ActionSupport{
	
	private String friendName;
	private String weiboUrl;
	private String csdnUrl;
	
	public String getFriendName() {
		return friendName;
	}
	
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	
	public String getWeiboUrl() {
		return weiboUrl;
	}
	
	public void setWeiboUrl(String weiboUrl) {
		this.weiboUrl = weiboUrl;
	}
	
	public String getCsdnUrl() {
		return csdnUrl;
	}
	
	public void setCsdnUrl(String csdnUrl) {
		this.csdnUrl = csdnUrl;
	}
	
	public String addFriend() {
		Friend friend = new Friend();
		ActionContext context = ActionContext.getContext();
		int userID = (int) context.getSession().get("userID");
		User user = Dao.getUser(userID);
		friend.setUser(user);
		friend.setFriendName(friendName);
		Dao.saveFriend(friend);
		return SUCCESS;
	}
	
	
//	public String addWeiboUrlToFriend() {
//		Friend friend = new Friend();
//		ActionContext context = ActionContext.getContext();
//		int userID = (int) context.getSession().get("userID");
//		User user = Dao.getUser(userID);
//		
//		if (weiboUrl == null) {
//			friend.setHasWeibo(false);
//		} else {
//			friend.setHasWeibo(true);
//			WeiboUrl weiboUrlObj = Dao.saveWeiboUrl(weiboUrl);
//			friend.setWeiboUrl(weiboUrlObj);
//		}
//	}
}
