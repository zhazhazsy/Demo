package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.dbBean;
import user.mune;
import user.person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public String goUser() throws SQLException{
        ResultSet rs = null;
        String id = (String) application.get("myid");
        sql="SELECT * FROM buy,mune,`user` WHERE `user`.`id` = buy.id AND mune.MuneId = buy.muneid AND buy.`id` = '"+id+"'";
        Map<String, Object> session = ax.getSession();
        try {
            rs = dbBean.executeQuery(sql);
            } catch (SQLException e) {
            e.printStackTrace();
        }
        List<mune> list = new ArrayList<mune>();
        while (rs.next()){
            String price = rs.getString("price")+"元X"+rs.getString("amount")+"份";
            String state = null;
            if(Integer.parseInt(rs.getString("state"))==1){
                state = "尚未付款";
            }else if(Integer.parseInt(rs.getString("state"))==2){
                state = "待收货";
            }else if(Integer.parseInt(rs.getString("state"))==4){
                state = "已确认收货";
            }else {
                state = "666";
            }
            list.add(new mune(rs.getString("muneid"),rs.getString("MenuName"),price,state));
        }
        session.put("list",list);
        return "goUser";
    }
}
