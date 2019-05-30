package cn;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import dao.dbBean;
import user.evaluate;
import user.mune;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class evaluateAction extends ActionSupport {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public static String sql="";
    ActionContext ax =  ActionContext.getContext();

    public String execute() throws SQLException{
        ValueStack vs = ax.getValueStack();
        ResultSet rs = null;
        ResultSet rst = null;
        sql = "select * from mune where MuneId = '"+id+"'";
        try {
            rs = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            ax.getSession().put("id",rs.getString("MuneId"));
            ax.getSession().put("munename",rs.getString("MenuName"));
            ax.getSession().put("price",rs.getString("Price"));
        }
        sql = "select * from buy where muneid = '"+id+"'";
        try {
            rst = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<evaluate> list = new ArrayList<evaluate>();
        if(rst!=null){
            String []add = {"img/tou/tou1.jpg","img/tou/tou2.jpg","img/tou/tou3.jpg","img/tou/tou4.jpg","img/tou/tou5.jpg","img/tou/tou6.jpg","img/tou/tou7.jpg","img/tou/tou8.jpg","img/tou/tou9.jpg","img/tou/tou10.jpg"};
            while (rst.next()){
                int a = (int)(Math.random()*(10-1+1));
                list.add(new evaluate(rst.getString("id"),rst.getString("message"),add[a]));
            }
        }
        ax.getSession().put("list",list);
        return SUCCESS;
    }
}
