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
import java.util.Map;

public class test extends ActionSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String sql = "";
    public String execute() throws SQLException {
        ResultSet rst = null;
        Map<String, Object> sission = ActionContext.getContext().getSession();
        List<mune> list = new ArrayList<mune>();
        sql = "SELECT * FROM mune where MenuName like '%"+name+"%' limit 0,5";
        try {
             rst = dbBean.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            while (rst.next()) {
                list.add(new mune(rst.getString("MuneId"), rst.getString("MenuName"), rst.getString("Price"), "1"));
            }
        sission.put("list", list);
        return SUCCESS;
    }
}
