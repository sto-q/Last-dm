
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String user=(String) session.getAttribute("username");
  if(user==null){//登录超时，因此session超时了就会被回收，那么session中内容就没有了 然后用户又发起请求，客户端发现浏览器传过来的JSESSIONID不存在了，就重新创造一个新的session，就没有内容了 就可以判定是否超时
    response.sendRedirect("login.jsp");
  }
%>
