package test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import dao.dbBean;
import user.mune;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test extends ActionSupport {
    public static String sql = "";
    public String execute() throws SQLException {
        System.out.println("------------------------------");
        System.out.println("-66666666666666666666666666666666");
        ResultSet rst = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        List<mune> list = new ArrayList<mune>();
        sql = "SELECT * FROM mune";
        try {
             rst = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rst.next()) {
            list.add(new mune(rst.getString("MuneId"),rst.getString("MenuName"),"1","1"));
        }
        vs.set("list", list);
        return "success";
    }
}
