<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 20.10.2018
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin add news page</title>
</head>
<body>
<%
    if (session.getAttribute("username") == null)   response.sendRedirect("/admin/login");
%>

<h1>Admin add news file</h1>

<div>
    <form method="get">
        <label>Title: <input type="text" name="title"><br></label>
        <label>Preview: <input name="preview"><br></label>
        <label>Text body: <input name="textbody"><br></label>

        <button type="submit" name="submit_text">Submit</button><br>
    </form>
</div>

<a href="${pageContext.request.contextPath}/admin/">back</a>

</body>
</html>
