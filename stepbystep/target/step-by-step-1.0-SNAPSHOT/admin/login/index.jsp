<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 28.10.2018
  Time: 7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Login admin page</h1>

<form action="${pageContext.request.contextPath}/admin/login" method="post">
    <label>Login:
        <input type="text" name="login"><br>
    </label>

    <label>Password:
        <input type="password" name="password"><br>
    </label>

    <input type="submit" value="Log in">
</form>
</body>
</html>
