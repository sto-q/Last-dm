<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application内置对象</title>
</head>
<%
    Integer count=(Integer)application.getAttribute("count");
    if(count==null){//表示第一个用户访问
       count=1;
    }else {
        count+=1;
    }
    application.setAttribute("count",count);
    //表示第一个用户访问
//    application.setAttribute("count",1);
%>
<body>
<div><%=application.getClass().getName()%></div>
<div>网站访问次数:<%= count%></div>
</body>
</html>
