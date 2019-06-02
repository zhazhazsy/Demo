package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation actionInvocation)throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("myid");
        if (user==null){
            HttpServletResponse response = ServletActionContext.getResponse();
            response.sendRedirect("/index.jsp");
            return null;
        }else {
            return actionInvocation.invoke();
        }
    }
}
