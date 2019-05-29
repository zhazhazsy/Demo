package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.dbBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class goShopping extends ActionSupport {
    private String menuid;
    private String menu;
    private String amounts;

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    ActionContext ax = ActionContext.getContext();
    Map<String, Object> application = ax.getApplication();
    public static String sql = "";
    public static String sql2 = "";
    public static String sql3 = "";

    public String execute() throws SQLException {
        int res = 0;
        int amount = 0;
        ResultSet res1 = null;
        String id = (String) application.get("myid");
        //查询购物车是否已经有该订单
        sql2 = "select * from buy where id = '" + id + "' and muneid = '" + menuid + "' and state = 1";
        try {
            res1 = dbBean.executeQuery(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (res1.next()){
            //有的话数量增加就行了
            amount = Integer.parseInt(res1.getString("amount")) + Integer.parseInt(amounts);
            sql3 = "update buy set amount = '" + amount + "' where id = '" + id + "' and muneid = '" + menuid + "' and state = 1";
            try {
                res = dbBean.executeUpdate(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }  else {
            //没有就添加新购物车
            sql = "INSERT INTO buy (`id`, `muneid`,`amount`) VALUES ('" + id + "', '" + menuid + "','" + amounts + "')";
            try {
                res = dbBean.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
            return menu;
        }
}
