package com.example.jsp3.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//如果为/*所有请求都将拦截,登录也拦截造成没有登录也超时
//所有需要在过滤的时候,对某些不需要的请求放行
@WebFilter("/*")
public class TimeoutFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("TimeoutFilter 开始执行");
        String requsetURI=req.getRequestURI();//获取req标识符
        String contextPath=req.getContextPath();//获取req上下文路径
        requsetURI=requsetURI.replace(contextPath,"");//将URI中的项目名替换为空字符串就是去掉上下文，得到 "/showUserInfo"
        if("/".equals(requsetURI)||"/showUserInfo".equals(requsetURI)||requsetURI.startsWith("/second")){

            //没有登录超时,让下一个过滤器做事情
            chain.doFilter(req,res);
            System.out.println("time放行"+requsetURI);
        }else {

            HttpSession session=req.getSession();
            Object user=session.getAttribute("user");
            if(user==null){//登录超时直接跳转
                res.sendRedirect("second.jsp");
            }else {
                //没有登录超时,让下一个过滤器做事情
                chain.doFilter(req,res);
            }
        }



    }
}
