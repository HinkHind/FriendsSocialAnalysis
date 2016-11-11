package controller;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import hibernateDao.Dao;
import hibernateMapping.User;

public class SignUp extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String signUp() {
		
		User user = new User(userName, password);
		System.out.println(userName+" "+password);
		Dao.saveUser(user);
		ActionContext context = ActionContext.getContext();
		Map sess = context.getSession();
		sess.put("userId", user.getUserId().intValue());
		
		return SUCCESS;
	}
	
	
	
	
}
