<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-09
  Time: 오전 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
<%-- <%= request.getAttribute("member")%>로 표현할 수 있지만 너무 복잡하다.   --%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a></body>
</html>
