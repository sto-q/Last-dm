package com.example.jsp7.listenter;


import com.example.jsp7.Jdbc.JdbcUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@WebListener//表示是一个监听器
public class APPlicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Servlet上下文初始化");
        //获取servlet上下文
        ServletContext context=sce.getServletContext();
        String jdbcConfig=context.getInitParameter("jdbcConfig");
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(jdbcConfig);
        Properties props=new Properties();
        try{
            props.load(is);
            //对数据源进行初始化操作
            JdbcUtil.initDataSource(props);
//            System.out.println("从类路径加载的配置: " + props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet上下文销毁");
        JdbcUtil.destroyDataSource();
    }
}
