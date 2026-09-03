<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>成绩信息展示</title>
</head>
<body>
<c:if test="${sessionScope.aaa.score>80}" var="result" scope="request">
  <div>成绩高于80</div>
</c:if>
<div>成绩高于80吗? ${requestScope.result}</div>

<c:choose>
  <c:when test="${sessionScope.aaa.score>90}">
    <div>很好</div>
  </c:when>
  <c:when test="${sessionScope.aaa.score>80}">
    <div>好</div>
  </c:when>
  <c:when test="${sessionScope.aaa.score>70}">
    <div>还好</div>
  </c:when>
  <c:otherwise>
    <div>差</div>
  </c:otherwise>
</c:choose>

<table>
  <thead>
  <tr>
    <th>姓名</th>
    <th>成绩</th>
    <th>考试时间</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${sessionScope.scores}" var="score" begin="2" step="2" end="14">
    <tr>
      <td>${score.name}</td>
      <td>${score.score}</td>
<%--      <td>${score.examData}</td>--%>
      <td>
        <fmt:formatDate value="${score.examData}" pattern="yyyy-MM-dd HH:mm:ss"/>
      </td>
    </tr>

  </c:forEach>
  </tbody>
</table>
<div>
  货币类型的数字:<fmt:formatNumber value="100" type="currency"/>
</div>
<div>
  数字格式化·\:<fmt:formatNumber value="12345.3450000000000000" type="number" maxIntegerDigits="4" maxFractionDigits="3"/>
</div>
<div>
  数字格式化:<fmt:formatNumber value="12345.34576567" type="number" pattern="###############.##"/>
</div>
<div>
  百分比数字:<fmt:formatNumber value="12345.34576567" type="percent" maxIntegerDigits="3" maxFractionDigits="2"/>
</div>

</body>
</html>
