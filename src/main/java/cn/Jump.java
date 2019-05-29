package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.dbBean;

import java.sql.SQLException;
import java.util.Map;

public class Jump extends ActionSupport {
    ActionContext ax =  ActionContext.getContext();
    Map<String,Object> application = ax.getApplication();
    public static String sql="";
    public String goMain1(){
        return "goMenu1";
    }
    public String goMain2(){
        return "goMenu2";
    }
    public String goMain3(){
        return "goMenu3";
    }
    public String goMain4(){
        return "goMenu4";
    }
    public String goMain5(){
        return "goMenu5";
    }
    public String goMain6(){
        return "goMenu6";
    }
    public String goMymessage(){
        return "goMymessage";
    }
    public String goAddress(){
        return "goAddress";
    }
    public String goRoot(){
        return "goRoot";
    }
    public String goBalance(){
        return "goBalance";
    }
    public  String goRecharge(){
        int rs=0;
        String id = (String) application.get("myid");
        String x = (String) application.get("balance");
        int y = Integer.parseInt(x)+100;
        String money = String.valueOf(y);
        sql="Update user set `balance`= balance+100 where id = '"+id+"'";
        try {
            rs = dbBean.executeUpdate(sql);
            if(rs!=0){
                application.put("balance",money);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "goRecharge";
    }
    public String goGoods(){
        return "goGoods";
    }
}
