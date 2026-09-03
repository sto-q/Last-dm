<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response内置对象</title>
</head>
<%
    String username="",password="";
    boolean rememberMe=false;
    //从请求中获取cookie信息
    Cookie[]cookies=request.getCookies();
    if(cookies!=null){
        for(Cookie c:cookies){
            String name=c.getName();
            if("username".equals(name)){
                username=c.getValue();
            }else if("password".equals(name)){
                password=c.getValue();
            }else if("rememberMe".equals(name)){
                rememberMe="on".equals(c.getValue());
            }
        }
    }//这里通过cookie将上一次内容取出来赋值如果点击了记住密码就有值没点就没有
%>
<body>
 <form action="process.jsp" method="post">
   <div>
       <span>用户名</span>
       <input type="text" name="username" value="<%=username%>">
   </div>
   <div><span>密码</span><input type="password" name="password" value="<%=password%>"></div>

     <div> <input type="checkbox" name="rememberMe"<%=rememberMe?"checked":""%>">记住密码</div>

   <div>
     <input type="submit" value="登录">
   </div>
 </form>
</body>
</html>
