package com.example.jsp7.Jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.jsp7.handler.ResultHandler;
import com.example.jsp7.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static final DruidDataSource dataSource=new DruidDataSource();//创建一个全局唯一的、用于管理数据库连接的数据源对象

    /***
     * 初始化数据源
     * @param props
     */
    public static void initDataSource(Properties props){
        dataSource.configFromPropety(props);
    }

    /**
     * 关闭数据源
     */
    public static void destroyDataSource(){
        dataSource.close();
    }

    /**
     * 封装的万能查询
     *
     * @param sql
     * @param handler
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T query(String sql, ResultHandler<T> handler, Object...params){
        try {
            Connection conn=dataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            if(params!=null&&params.length>0){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            ResultSet rs=ps.executeQuery();
            T t=handler.handle(rs);
            rs.close();
            ps.close();
            conn.close();
            return  t;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 万能更新
     * @param sql
     * @param params
     * @return
     */
    public static int upData(String sql,Object...params){
        Connection conn=null;
        try {
             conn=dataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            if(params!=null&&params.length>0){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            int affectedRows=ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
            return  affectedRows;
    }catch (SQLException e){
            e.printStackTrace();
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return -1;
    }
}
