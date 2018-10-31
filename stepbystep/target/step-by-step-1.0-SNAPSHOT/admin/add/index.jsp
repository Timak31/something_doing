<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 27.10.2018
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add admin</title>
</head>
<body>
<h1>Add admin page</h1>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/admin/login");
    }
%>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/add" method="post">
    <label>Title: <input type="text" name="title"><br></label>
    <label>Preview: <textarea name="preview" id="preview_id" cols="30" rows="3"></textarea><br></label>
    <label>Text body: <textarea name="text_body" id="textarea_id" cols="30" rows="10"></textarea><br></label>
    <label>Picture: <input type="file" name="picture"><br></label>

    <input type="submit" value="Add it dates">
</form>

</body>
</html>
