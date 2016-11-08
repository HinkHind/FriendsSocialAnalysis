package hibernateDao;

import java.util.HashSet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import hibernateMapping.*;
import hibernateUtil.HibernateUtil;

public class Dao {
	
	
	private Dao() {
		
	}
	/**
	 * suppose that the parameter user is valid.
	 * @param user
	 */
	public static void saveUser(User user) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	public static boolean hasUserName(String userName) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		String sqlString = "select * from user where userName = :userName";
		List userNameList = session.createSQLQuery(sqlString).addScalar("userName",StandardBasicTypes.STRING).setString("userName",userName)
				.list();
		transaction.commit();
		HibernateUtil.closeSession();
		return !userNameList.isEmpty();
	}
	
	public static User isValidLogin(String userName, String password) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		String sqlString = "select * from user where userName = :userName and password = :password";
		List queryList = session.createSQLQuery(sqlString).addEntity(User.class)
				.setString("userName",userName)
				.setString("password", password)
				.list();
		transaction.commit();
		HibernateUtil.closeSession();
		
		if (queryList.isEmpty()) {
			return null;
		} else {
			return (User) queryList.get(0);
		}
		
		
	}
	
	public static User getUser(String userName) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		String sqlString = "select * from user where userName = :userName";
		List userList = session.createSQLQuery(sqlString).addEntity(User.class).
				setString("userName", userName).list();
		transaction.commit();
		HibernateUtil.closeSession();
		
		if (userList.isEmpty()) {
			return null;
		} else {
			return (User) userList.get(0);
		}
	}
	
	public static User getUser(int userID) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, userID);
		
		transaction.commit();
		HibernateUtil.closeSession();
		return user;
	}
	
	
	public static void saveFriend(Friend friend) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(friend);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
//	public static WeiboUrl saveWeiboUrlToFriend(String weiboUrl) {
//		Session session = HibernateUtil.currentSession();
//		Transaction transaction = session.beginTransaction();
//		String sqlString = "select * from weibo_url where weiboUrl = :weiboUrl";
//		List queryList = session.createSQLQuery(sqlString).addEntity(WeiboUrl.class)
//				.setString("weiboUrl", weiboUrl)
//				.list();
//		
//		WeiboUrl weiboUrl2 = null,weiboUrl3 = null;
//		if (queryList.isEmpty()) {
//			weiboUrl2 = new WeiboUrl(weiboUrl, 1, "t", new HashSet<>(), new HashSet<>());
//			session.save(weiboUrl2);
//		} else {
//			weiboUrl3 = (WeiboUrl) queryList.get(0);
//			weiboUrl3.setCount(weiboUrl3.getCount() + 1);
//		}
//		
//		
//		transaction.commit();
//		HibernateUtil.closeSession();
//		
//		if (queryList.isEmpty()) {
//			return weiboUrl2;
//		} else {
//			return weiboUrl3;
//		}
//		
//	}
	
	
	
}
