package 高级Java程序开发.第五次作业;


import java.sql.*;
public class BaseConnection {
    public static void main(String [] args) {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Test";  // 我的数据库名 Test
        String userName="zh";   // 填写你的用户名，我的是sa
        String userPwd="1234567890";   // 填写你的密码
        try {
            Class.forName(driverName);
            Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功");



        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.print("连接失败");
        }
    }
}
