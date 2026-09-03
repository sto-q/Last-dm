<%@ page import="com.example.jsp2.popj.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jspl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
 <html>
<head>
    <title>jstl标签使用</title>
</head>

<body>
<%
    User user=new User();
%>
<div>
<%--  相当于在页面创建了一个text变量--%>
  <c:set var="text" value="测试" scope="page"/>
    <c:set target="<%=user%>" value="管理员" property="name"/>
</div>
<div>
  页面范围内的变量:${pageScope.text}
</div>
<%--移除页面text变量--%>
<c:remove var="text" scope="page"/>
<div>
    页面范围内的变量:${pageScope.text}
</div>
<div>
    <%=user.getName()%>
</div>
</body>
</html>
