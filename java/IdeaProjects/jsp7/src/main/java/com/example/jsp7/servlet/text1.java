package com.example.jsp7.servlet;

import java.sql.*;

public class text1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai&useSSL=false";
        String username = "root";
        String password = "159951";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, sex, age, score FROM stus")) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" +
                        rs.getString("name") + "-" +
                        rs.getInt("sex") + "-" +
                        rs.getInt("age") + "-" +
                        rs.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println("数据库错误：" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}