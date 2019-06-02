package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import dao.dbBean;
import user.mune;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class goodsAction extends ActionSupport {
    private String key;
    private String prices;
    private String am;

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    ActionContext ax =  ActionContext.getContext();
    Map<String,Object> application = ax.getApplication();
    public static String sql="";
    public static String sqlt="";
    public static String sqly="";
    public String execute() throws SQLException {
        String id = (String) application.get("myid");
        String k = (String) application.get("balance");
        int mymoney = Integer.parseInt(k);
        int res = 0,res2=0;
        ResultSet rs = null;
            //key不为空则是处理下单
        if (key!=null){
            //对值栈余额进行更新
            if(mymoney - (Integer.parseInt(prices)*Integer.parseInt(am))<0) {
                return "Fal";
            }
            int newmoney = mymoney - (Integer.parseInt(prices)*Integer.parseInt(am));
            application.put("balance",String.valueOf(newmoney));
            //先将该状态改为已经下单（2）
            sqlt = "update buy set state = 2 where state = 1 and muneid = '"+key+"' and id = '"+id+"'";
            //对数据库余额进行扣除
            sqly = "update user set balance = '"+newmoney+"' where id = '"+id+"'";
            try {
                res = dbBean.executeUpdate(sqlt);
                res2 = dbBean.executeUpdate(sqly);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            //将购物车的内容放入值栈中
        ValueStack vs = ActionContext.getContext().getValueStack();
        sql = "SELECT * FROM buy,mune,`user` WHERE `user`.`id` = buy.id AND mune.MuneId = buy.muneid AND buy.state = 1 AND buy.`id` = '"+id+"'";
        try {
            rs = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<mune> list = new ArrayList<mune>();
            if (rs != null) {
                while (rs.next()) {
                    list.add(new mune(rs.getString("muneid"),rs.getString("MenuName"),rs.getString("price"),rs.getString("amount")));
                }
                vs.set("list", list);
            }
            //将已经下单的内容放进值栈
        sql = "SELECT * FROM buy,mune,`user` WHERE `user`.`id` = buy.id AND mune.MuneId = buy.muneid AND buy.`id` = '"+id+"' AND (buy.state = 2 or buy.state = 3)";
        try {
            rs = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<mune> list2 = new ArrayList<mune>();
        if (rs != null) {
            while (rs.next()) {
                list2.add(new mune(rs.getString("muneid"),rs.getString("MenuName"),rs.getString("price"),rs.getString("amount")));
            }
            vs.set("list2", list2);
        }
        return "goGoods";
    }
}
