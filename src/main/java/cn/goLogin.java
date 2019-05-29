package cn;

import com.opensymphony.xwork2.ActionContext;
import dao.dbBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class goLogin {
    public static String sql="";
    public  static String testQueryByID(String ID,String pwd){
        ActionContext ax =  ActionContext.getContext();
        Map<String,Object> application = ax.getApplication();
        ResultSet rs = null;
        String result = null;
        sql = "SELECT * FROM user where id = '"+ID+"' and pwd = '"+pwd+"'";
        try {
            rs = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs!=null){
                while(rs.next()){
                    application.put("add",rs.getString("add"));
                    application.put("balance",rs.getString("balance"));
                    application.put("name",rs.getString("name"));
                    result =rs.getString("id");
                }
            }
            else{
                result = null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
