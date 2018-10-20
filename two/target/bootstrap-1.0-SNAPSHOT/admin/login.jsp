<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 20.10.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Login.jsp file</h1>
<div>
    <form method="post">
        <label>Login:
            <input type="text" name="login"><br>
        </label>

        <label>Password:
            <input type="password" name="password"><br>
        </label>

        <button type="submit">Submit</button>
    </form>
</div>

<a href="${pageContext.request.contextPath}/admin/">back</a>
</body>
</html>
