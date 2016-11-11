package controller;

import com.opensymphony.xwork2.ActionContext;

public class Util {
	public static int getUserIdFromSession() {
		ActionContext context = ActionContext.getContext();
		return (int) context.getSession().get("userId");
	}
}
