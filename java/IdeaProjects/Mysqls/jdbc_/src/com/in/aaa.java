package com.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class aaa {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "159951";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection连接数据库  DriverManager获取数据库中对象Connection
            Connection conn= DriverManager.getConnection(url,username, password);
            if(conn!=null){
                System.out.println("连接成功");
            }else{
                System.out.println("连接失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
