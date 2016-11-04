package hibernateDao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import hibernateMapping.*;
import hibernateUtil.HibernateUtil;

public class Dao {
	/**
	 * suppose that the parameter user is valid.
	 * @param user
	 */
	public static void addUser(User user) {
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
	
	public User getUser(String userName) {
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
	
}
