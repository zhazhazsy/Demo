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
        /*查询该商品*/
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
        /*查询该商品所有购买信息和评价*/
        sql = "select * from buy,`user` where state = 4 and `user`.id=buy.id and muneid = '"+id+"'";
        try {
            rst = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<evaluate> list = new ArrayList<evaluate>();
        if(rst!=null){
                while (rst.next()){
                list.add(new evaluate(rst.getString("id"),rst.getString("message"),rst.getString("tou")));
            }
        }
        ax.getSession().put("list",list);
        return SUCCESS;
    }
}
