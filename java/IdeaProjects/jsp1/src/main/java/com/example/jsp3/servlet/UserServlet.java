package com.example.jsp3.servlet;

import com.example.jsp3.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet就表示标识的类是一个servlet,不需要在web中配置
@WebServlet("/showUserInfo")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里只是简单的开发,实际中数据的获取通过业务层从DAO获取,然后组装完成整个模型
        User user=new User("李四","男",16);
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.println(user.toString());
        writer.flush();
        writer.close();
    }
}
