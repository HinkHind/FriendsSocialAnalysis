package hibernateUtil;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */	
public class HibernateUtil
{
	public static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			//����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��
			Configuration configuration = new Configuration()
				.configure();
			//��Configuration��ʵ��������һ��SessionFactoryʵ��
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��	
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();
	
	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		//������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			//����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}
	
	public static void closeSession()
		throws HibernateException 
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}