package cn;

import dao.dbBean;

import java.sql.SQLException;

public class goRegister {
    public static String sql="";
    public  static String addQueryByID(String ID,String pwd,String name,String sex,String phone,String add){
        String []addt = {"img/tou/tou1.jpg","img/tou/tou2.jpg","img/tou/tou3.jpg","img/tou/tou4.jpg","img/tou/tou5.jpg","img/tou/tou6.jpg","img/tou/tou7.jpg","img/tou/tou8.jpg","img/tou/tou9.jpg","img/tou/tou10.jpg"};
        int a = (int)(Math.random()*(10-1+1));
        int rs = 0;
        sql = "INSERT INTO USER (`id`, `pwd`, `name`, `sex`,`phone`, `add`,`tou`) VALUES('"+ID+"', '"+pwd+"', '"+name+"', '"+sex+"', '"+phone+"', '"+add+"','"+addt[a]+"') ";
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
