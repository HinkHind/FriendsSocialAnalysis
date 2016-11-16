package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import hibernateMapping.User;

public class Util {
	public static int getUserIdFromSession() {
		ActionContext context = ActionContext.getContext();
		return (int) context.getSession().get("userId");
	}
	
	public static void saveUserDateIntoSession(User user) {
		ActionContext context = ActionContext.getContext();
		Map sess = context.getSession();
		sess.put("userId", user.getUserId().intValue());
		sess.put("userName", user.getUserName());
		
	}
}
