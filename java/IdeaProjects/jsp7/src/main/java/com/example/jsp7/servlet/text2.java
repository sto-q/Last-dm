package com.example.jsp7.servlet;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 最简单的数据库访问示例
 * 通过 properties 文件配置连接池，查询用户表
 */
public class text2 {

    private static DruidDataSource dataSource;

    public static void main(String[] args) {
        try {
            // 1. 加载配置文件
            Properties props = new Properties();
            try (InputStream input =
                         text2.class.getClassLoader().getResourceAsStream("jdbcConfig.properties")) {

                if (input == null) {
                    System.out.println("找不到 db.properties 文件");
                    return;
                }
                props.load(input);
            }

            // 2. 创建数据源（连接池）
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
            System.out.println("数据库连接池初始化成功！");

            // 3. 执行查询
            queryUsers();

            // 4. 插入数据
            insertUser("张三", 25);

            // 5. 再次查询验证
            queryUsers();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭连接池
            if (dataSource != null) {
                dataSource.close();
                System.out.println("连接池已关闭");
            }
        }
    }

    /**
     * 查询所有用户
     */
    public static void queryUsers() {
        String sql = "SELECT id, name, age FROM user";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== 用户列表 ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("ID: %d, 姓名: %s, 年龄: %d%n", id, name, age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入用户
     */
    public static void insertUser(String name, int age) {
        String sql = "INSERT INTO user(name, age) VALUES(?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);

            int rows = ps.executeUpdate();
            System.out.println("\n插入了 " + rows + " 条记录");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}