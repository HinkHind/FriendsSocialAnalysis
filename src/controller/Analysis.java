package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateMapping.Friend;
import hibernateUtil.HibernateUtil;

public class Analysis extends ActionSupport{

	
	
	
	
	public String displayAnalysis() {
		ActionContext context = ActionContext.getContext();
		
		int friendId = (int)context.get("friendId");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
				
		transaction.commit();
		HibernateUtil.closeSession();
		
		
		return SUCCESS;
	}
}
