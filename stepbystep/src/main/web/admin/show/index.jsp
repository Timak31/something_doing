<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="app.entities.News" %>
<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 27.10.2018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show admin</title>
</head>
<body>
<h1>Show admin page</h1>

<%
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session sessionShow = sessionFactory.openSession();

    Query query =  sessionShow.createQuery("from News ");

    List<News> newsList = query.list();

    for (News news : newsList) {
%>

<p>
    <h3>
        <%=news.getId()%> - <%=news.getTitle()%> : <%=news.getPreview()%> : <%=news.getTextBody()%> : <%=news.getPictureName()%>
    </h3>
</p>

<%
    }

    sessionFactory.close();
%>


</body>
</html>
