package cn;

import dao.dbBean;

import java.sql.SQLException;

public class goRegister {
    public static String sql="";
    public  static String addQueryByID(String ID,String pwd,String name,String sex,String phone,String add){
        int rs = 0;
        sql = "INSERT INTO USER (`id`, `pwd`, `name`, `sex`,`phone`, `add`) VALUES('"+ID+"', '"+pwd+"', '"+name+"', '"+sex+"', '"+phone+"', '"+add+"') ";
        try {
            rs = dbBean.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rs==1){
            return "dd";
        }else{
            return "ff";
        }

    }
}
