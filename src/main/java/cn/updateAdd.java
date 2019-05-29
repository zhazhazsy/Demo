package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.dbBean;
import user.user;

import java.sql.SQLException;
import java.util.Map;

public class updateAdd extends ActionSupport implements ModelDriven<user> {
    private user user = new user();
    public user getModel() {
        return user;
    }
    ActionContext ax =  ActionContext.getContext();
    Map<String,Object> application = ax.getApplication();
    public static String sql="";
    public String execute(){
        int rs=0;
        String id = (String) application.get("myid");
        sql = "Update user set `add`='"+user.getMyadd()+"' where id = '"+id+"'";
        try {
            rs = dbBean.executeUpdate(sql);
            if(rs!=0){
                application.put("add",user.getMyadd());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
