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
	
	
}
