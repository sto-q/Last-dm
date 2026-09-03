package com.example.jsp3.servlet;

import jakarta.servlet.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class FirstServlet implements Servlet {

    private ServletConfig servletConfig;
    //ser初始化，只有初始化完成的才能提供处理请求的服务


    //ser的实例在ser处理的第一次请求才创建，创建后立刻调用初始化方法完成ser的初始化
    public FirstServlet() {
        System.out.println("创建servlet实例");
    }

    //init方法在servlet对象第一次处理请求时候才调用
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        this.servletConfig=servletConfig;
        //获取ser配置的所有参数名称
        Enumeration<String> initParameterNames=servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            //获取下一个参数名
            String parameterNames=initParameterNames.nextElement();
            String parameterValue=servletConfig.getInitParameter(parameterNames);
            System.out.println(parameterNames+"=>"+parameterValue);
        }
        System.out.println("编码测试：" + Charset.defaultCharset().displayName() + " => 你好Servlet");
        System.out.println("servlet初始化完成");
    }
    //获取ser配置
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //处理请求的服务方法
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("servlet处理请求并做出响应");
        String characterEncoding=request.getCharacterEncoding();
        System.out.println(characterEncoding);
        //设置字符集编码
        request.setCharacterEncoding("UTF-8");
         characterEncoding=request.getCharacterEncoding();
        System.out.println(characterEncoding);

        BufferedReader reader=request.getReader();
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        System.out.println("======================================");
        //获取request对象中存储的属性名称
        Enumeration<String> attributeNames=request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attrName=attributeNames.nextElement();
            Object attribute=request.getAttribute(attrName);
            System.out.println(attrName+"=>"+attribute);
        }
        System.out.println("======================================");

        //获取request对象中存储参数名称
        Enumeration<String> parameterNames=request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName=parameterNames.nextElement();
            Object parameter=request.getParameter(paramName);
            System.out.println(paramName+"=>"+parameter);
        }
        System.out.println("======================================");
        Map<String,String[]>parameterMap=request.getParameterMap();
        parameterMap.forEach((k,v)-> System.out.println(k+"=>"+ Arrays.toString(v)));


        System.out.println("===========================");
        System.out.println("响应的字符集编码:"+request.getCharacterEncoding());
        response.setCharacterEncoding("UTF-8");
        System.out.println("响应的字符集编码:"+request.getCharacterEncoding());
        System.out.println("响应的内容类型:"+response.getContentType());
        response.setContentType("text/html;charset=utf-8");
        System.out.println("响应的内容类型:"+response.getContentType());
        PrintWriter writer=response.getWriter();
        writer.print("登录请求以处理");//向页面输出数据的输出流
        writer.flush();
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }
    //ser销毁，不在提供服务
    @Override
    public void destroy() {
        System.out.println("servlet销毁");
    }

    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }
}

