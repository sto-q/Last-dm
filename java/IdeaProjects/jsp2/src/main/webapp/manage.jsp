
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理页面</title>
</head>
<body>
<%--${requestScope.user}<br>${sessionScope.user}--%>
<div>
    ${requestScope.user.name}&nbsp;&nbsp; ${requestScope.user["sex"]}
</div>
<div>
    ${sessionScope.user.name}&nbsp;&nbsp; ${sessionScope.user["sex"]}
</div>
<div>
    ${sessionScope.users[0].name}&nbsp;&nbsp; ${sessionScope.users[0]["sex"]}
</div>
<div>
    ${sessionScope.users[1].name}&nbsp;&nbsp; ${sessionScope.users[1]["sex"]}
</div>
<div>
    ${sessionScope.data.admin}&nbsp;&nbsp; ${sessionScope.data.text}
</div>
<div>
    ${sessionScope.data.admin <90?"垃圾":"还行"}&nbsp;&nbsp; ${sessionScope.data.text<90?"垃圾":"还行"}
</div>
<div>
    ${ empty sessionScope.data.admin}&nbsp;&nbsp; ${empty sessionScope.data.text}
</div>
</body>
</html>
