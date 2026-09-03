<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//  String username=request.getParameter("username");
//  String password=request.getParameter("password");
//  if("admin".equals(username)&&"123456".equals(password)){
//    //将用户名与密码存储在session中，因为session是针对用户来的，因此只有用户本人能够获取自己存储的数据
//      session.setAttribute("username",username);
//      session.setAttribute("password",password);
//      //设置超时时间为5秒
//      session.setMaxInactiveInterval(5);
//        response.sendRedirect("main.jsp");
    //页面重定至主界面
//    response.sendRedirect("main.jsp");
    //从请求中获取一个请求转发的对象，既然是请求转发，那么上一次请求的信息，转发的对象也应该清除，因此可以从转发的新 的请求中获取上一次请求的参数
//    RequestDispatcher dispatcher=request.getRequestDispatcher("main.jsp");
    // 实现请求转发
//    dispatcher.forward(request,response);
//  }
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String rememberMe=request.getParameter("rememberMe");
    if("admin".equals(username)&&"123456".equals(password)){
              session.setAttribute("username",username);//先将user与password赋值了
              session.setAttribute("password",password);
        //只有登录成功且勾选了记住密码的情况下才会记住密码
        if(!"on".equals(rememberMe)){//判断是否勾选记住密码
            username="";
            password="";
            rememberMe="";
        }//给cookie赋值
        Cookie usernameCookie=new Cookie("username",username);
        Cookie passwordCookie=new Cookie("password",password);
        Cookie rememberMeCookie=new Cookie("rememberMe",rememberMe);
        //记住密码是属于服务器对用户操作的一种响应，这个响应是使用cookie来存储密码与账号
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        response.addCookie(rememberMeCookie);
        response.sendRedirect("main.jsp");
    }

%>