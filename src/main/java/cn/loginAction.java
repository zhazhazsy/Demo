package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import user.user;

import java.util.Map;

public class loginAction extends ActionSupport implements ModelDriven<user> {
	private user user = new user();
	ActionContext ax =  ActionContext.getContext();
	Map<String,Object> application = ax.getApplication();

	public user getModel() {
		return user;
	}

	public String execute() {
		String result = null;
		result = goLogin.testQueryByID(user.getId(),user.getPwd());
		if(result!=null){
			application.put("myid",result);
			return "loginSuccess";
		}else{
			return "loginError";
		}
	}
}
