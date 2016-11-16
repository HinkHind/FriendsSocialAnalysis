package interceptor;

import utils.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import javassist.SerialVersionUID;

public class LoginInterceptor extends MethodFilterInterceptor{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
    protected String doIntercept(ActionInvocation invoker) throws Exception {  
        // TODO Auto-generated method stub  
  
        Object loginUserName = ActionContext.getContext().getSession().get(Constants.getUserId());  
        if(null == loginUserName){  
            return Constants.getSignInView();  // 这里返回用户登录页面视图  
        }  
        return invoker.invoke();  
    }  
}
