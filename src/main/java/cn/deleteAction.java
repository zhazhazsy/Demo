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
//乱七八糟的删除订单action
public class deleteAction extends ActionSupport {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public static String sql = "";
    public static String sql2 = "";
    ActionContext ax =  ActionContext.getContext();
    Map<String,Object> application = ax.getApplication();
    public String execute() throws SQLException {
        int rs = 0;
        ResultSet rst = null;
        String id = (String) application.get("myid");
        sql = "DELETE FROM buy WHERE id ='"+id+"' AND muneid = '"+key+"' AND state = '1' ";
        try {
            rs = dbBean.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ValueStack vs = ActionContext.getContext().getValueStack();
        sql2 = "SELECT * FROM buy,mune,`user` WHERE `user`.`id` = buy.id AND mune.MuneId = buy.muneid AND buy.state = 1 AND buy.`id` = '"+id+"'";
        try {
            rst = dbBean.executeQuery(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<mune> list = new ArrayList<mune>();
        if (rst != null) {
            while (rst.next()) {
                list.add(new mune(rst.getString("muneid"),rst.getString("MenuName"),rst.getString("price"),rst.getString("amount")));
            }
            vs.set("list", list);
        }
        sql2 = "SELECT * FROM buy,mune,`user` WHERE `user`.`id` = buy.id AND mune.MuneId = buy.muneid AND buy.`id` = '"+id+"' AND (buy.state = 2 or buy.state = 3)";
        try {
            rst = dbBean.executeQuery(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<mune> list2 = new ArrayList<mune>();
        if (rst != null) {
            while (rst.next()) {
                list2.add(new mune(rst.getString("muneid"),rst.getString("MenuName"),rst.getString("price"),rst.getString("amount")));
            }
            vs.set("list2", list2);
        }
        return SUCCESS;
    }
}
