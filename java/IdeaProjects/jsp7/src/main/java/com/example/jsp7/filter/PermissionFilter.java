//package com.example.jsp7.filter;
//
//import com.example.jsp7.service.impl.UserService;
//import com.example.jsp7.service.impl.UserServiceImpl;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebFilter("/*")
//public class PermissionFilter extends HttpFilter {
//    private UserService userService=new UserServiceImpl();
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        // 设置请求和响应的编码
//        req.setCharacterEncoding("UTF-8");
//        res.setCharacterEncoding("UTF-8");
//
//
//        String requestURI = req.getRequestURI();
//        String uri=requestURI.replace(req.getContextPath(),"");
//
//
//        if("/".equals(uri)||"login".equals(uri)||uri.endsWith(".jsp")||uri.startsWith("/js")){
//            chain.doFilter(req,res);
//        }else {
////            HttpSession session = req.getSession();
//            HttpSession session = req.getSession(false);
//            if (session == null || session.getAttribute("username") == null) {
//                // 未登录，重定向
//                return;
//            }
//            String username = session.getAttribute("username").toString();
//            if(username==null){
//                System.out.println("登录超时");
//            }else {
//                //这里应该去数据库查询当前用户是否具有访问这个URL的权限
//                if(userService.hasPermission(username,uri)){
//                    chain.doFilter(req,res);
//                }else {
//                    res.setCharacterEncoding("UTF-8");
//                    PrintWriter writer=res.getWriter();
//                    writer.print("没有访问权限");
//                    writer.flush();
//                    writer.close();
//                }
//            }
//
//        }
//    }
//}
