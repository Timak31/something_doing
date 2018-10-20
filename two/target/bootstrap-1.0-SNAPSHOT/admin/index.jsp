<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 20.10.2018
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index admin</title>
</head>
<body>

<h1>admin index file</h1>

<%
    if (session.getAttribute("username") == null) response.sendRedirect("/admin/login");
%>

<a href="${pageContext.request.contextPath}/admin/login">Login page</a>
<a href="${pageContext.request.contextPath}/admin/logout">Log out</a>
<a href="${pageContext.request.contextPath}/admin/addNews">Add news</a>



</body>
</html>
