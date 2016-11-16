package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogOut extends ActionSupport{
	public String logOut() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.remove("userId");
		session.remove("friendId");
		session.remove("selectedPlatform");
		session.remove("userName");
		
		return SUCCESS;
	}
}
