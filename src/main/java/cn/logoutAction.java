package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class logoutAction extends ActionSupport {
    public String execute(){
        ActionContext ax =  ActionContext.getContext();
        Map<String,Object> application = ax.getApplication();
        Map<String, Object> session = ax.getSession();
        session.remove("myid");
        application.remove("myid");
        application.remove("add");
        application.remove("name");
        application.remove("balance");
        session.remove("tou");
        session.remove("list");
        return SUCCESS;
    }
}
