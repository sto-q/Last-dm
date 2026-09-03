<%@ page import="java.util.Arrays" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //设置请求的字符集编码
    request.setCharacterEncoding("UTF-8");

    //从请求中获取参数username的值
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    //因为前端输出的数据是数组，用数组接收
    String[] channels =request.getParameterValues("channel");

    for(String channel: channels){
        //IOS编码下获取字节数据
        byte[] bytes=channel.getBytes(StandardCharsets.ISO_8859_1);
        String s=new String(bytes,StandardCharsets.UTF_8);
    }

%>
<div><%=username%></div>
<div><%=password%></div>
<%--post请求发送的信息如果是中文可能是乱码 可以在request对象中先设置请求的编码格式，再从request对象中取值--%>
<%--如果get发送请求参数是中文，也可能乱码，可以使用字符串的转码方法来解决--%>
<div><%=Arrays.toString(channels)%></div>
