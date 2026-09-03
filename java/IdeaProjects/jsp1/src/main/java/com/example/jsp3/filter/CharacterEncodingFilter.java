package com.example.jsp3.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

//字符集编码过滤器 /*拦截所有路径
@WebFilter(urlPatterns = "/*",initParams = {
        @WebInitParam(name = "encoding",value = "UTF-8")
})
public class CharacterEncodingFilter implements Filter {
    private String encoding;


    public CharacterEncodingFilter() {
        System.out.println("过滤器创建实例");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {//初始化只执行第一次
        System.out.println("过滤器初始化");
         encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器过滤处理");
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("过滤器过滤处理 - 请求路径：" +req.getRequestURI());
        request.setCharacterEncoding(encoding);//设置utf-8格式
        response.setCharacterEncoding(encoding);
        //多个过滤器会形成一条过滤链,当前过滤器完成后必须调用doFilter方法
        //让下一个过滤器做事情,直到所有的过滤器完成才将1请求送达servlet 如果过滤的请求不需要servlet来处理就就不需要调用filterChain.doFilter
        //对象做出响应即可
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
