<%@ page import="app.test.entities.People" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="app.entities.News" %><%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 27.10.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update admin</title>
</head>
<body>
<h1>Update admin page</h1>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/admin/login");
    }

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session sessionShow = sessionFactory.openSession();

    Query query =  sessionShow.createQuery("from News ");

    List<News> newsList = query.list();

    for (News news : newsList) {
%>

<p>
<h3>
    <%=news.getId()%> - <%=news.getTitle()%>
</h3>
</p>

<%
    }

    sessionFactory.close();
%>


<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/update" method="post">
    <label>ID for update: <input type="text" name="id_update"><br></label>
    <label>Title update: <input type="text" name="title_update"><br></label>
    <label>Preview update: <textarea name="preview_update" id="preview_id" cols="30" rows="3"></textarea><br></label>
    <label>Text body update: <textarea name="text_body_update" id="textarea_id" cols="30" rows="10"></textarea><br></label>
    <label>Picture update: <input type="file" name="picture_update"><br></label>

    <input type="submit" value="Update this dates">
</form>

<%
    sessionFactory.close();
%>
</body>
</html>
