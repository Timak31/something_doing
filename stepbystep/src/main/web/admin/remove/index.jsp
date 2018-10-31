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
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove admin</title>
</head>
<body>
<h1>Remove admin page</h1>

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

<form action="${pageContext.request.contextPath}/admin/remove" method="post">
    <label>
        Enter ID for remove: <input type="text" name="id_remove">
    </label>
    <input type="submit" value="Remove it!">
</form>
</body>
</html>
