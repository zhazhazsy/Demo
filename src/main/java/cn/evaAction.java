package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.dbBean;

import java.sql.SQLException;
import java.util.Map;

public class evaAction extends ActionSupport {
    ActionContext ax =  ActionContext.getContext();
    Map<String,Object> application = ax.getApplication();
    private String textarea;
    private String key;
    private String number;
    String id = (String) application.get("myid");
    public static String sql="";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public String execute() throws SQLException {
        int res = 0;
        if(textarea.equals("")){
            textarea="该用户未作出任何评价！";
        }
        sql="update buy set state = 4,message = '"+textarea+"' where muneid = '"+key+"' and id = '"+id+"' and number = '"+number+"'";
        try {
            res = dbBean.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if (res!=0){
            System.out.println("success!");
        }
        return "success";
    }
}
