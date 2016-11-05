package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateDao.Dao;
import hibernateMapping.User;

public class SignIn extends ActionSupport{
	
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


	
	

	public String signIn() {
		
		User signInUser = Dao.isValidLogin(userName, password);
		if (signInUser == null){
			return ERROR;
		} else {
			ActionContext context = ActionContext.getContext();
			Map sess = context.getSession();
			sess.put("userID", signInUser.getUserId().intValue());
			
			return LOGIN;
		}
		
	}
	
}
