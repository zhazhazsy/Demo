package dao;
import java.sql.*;

public class dbBean {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://127.0.0.1:3306/webroot";
    static String user = "root";
    static String password = "123";
    static Connection aConnection;
    public static Connection connectDB(){
        try{
            Class.forName(driver);
            aConnection = DriverManager.getConnection(url,user,password);
            if(aConnection.isClosed()
                    )
            {
                System.out.println("Succeeded!");
            }
        }catch(ClassNotFoundException e)
        {
            System.out.println(e);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return aConnection;
    }
    public static ResultSet executeQuery(String sql) throws SQLException{
        connectDB();
        ResultSet rs = null;
        Statement stmt =  aConnection.createStatement();
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int executeUpdate(String sql) throws SQLException{
        connectDB();
        int rs = 0;
        PreparedStatement stmt =  aConnection.prepareStatement(sql);
        rs = stmt.executeUpdate();
        return rs;
    }
}
