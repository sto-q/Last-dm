package com.example.jsp3.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SecondServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext=config.getServletContext();//获取config路径上下文
        Enumeration<String> initParameterNames=servletContext.getInitParameterNames();//返回servlet参数名称以枚举的形式逐个取出
        System.out.println("上下文路径"+servletContext.getContextPath());
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("读取请求头部信息.....");
        Enumeration<String> headerNames=req.getHeaderNames();//获取头部信息以枚举的形式存在
        while (headerNames.hasMoreElements()){
            String headerName=headerNames.nextElement();
            String headerValue=req.getHeader(headerName);
            System.out.println(headerName+"=>"+headerValue);
        }
        System.out.println("+++++++++++++++++++++++++++");
        String contextPath=req.getContextPath();//获取上下文路径
        System.out.println("上下文路径"+contextPath);
        String requsetURI=req.getRequestURI();//包含上下文路径
        requsetURI=requsetURI.replace(contextPath,"");
        System.out.println("当前请求路径"+requsetURI);
        System.out.println();


        //这里模拟登录成功,将用户名存储session如果session超时,代表用户很久没有在页面操作 造成超时
        //只需要判断session中是否有  用户名即可,没有就超时
        //新的session中没有用户
        HttpSession session=req.getSession();
        session.setAttribute("user","admin");
        System.out.println("开始做出响应");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");//告诉浏览器是text与html格式并且显示内容是utf-8格式请按这个方式解析显示
        PrintWriter writer=resp.getWriter();//获取一个向浏览器输出信息的字符流
        writer.println("请求已处理");
        writer.flush();
        writer.close();

    }
}
