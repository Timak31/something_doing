<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="app.entities.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 18.10.2018
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Файне місто Тернопіль</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body>

<%
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session1 = sessionFactory.openSession();
    Query query = session1.createQuery("from News");

    int i = 0;

    List<News> newsList = query.list();
    for (News news : newsList) {

%>
<div class="teaser">
    <h2 class="title-node">
        <a href="новости/метро.html"><%=news.getTitle()%></a> <!--заголовок-->
    </h2>
    <img src="image/<%=news.getPictureName()%>" width="163px" height="122px" alt="<%=news.getTitle()%>"><%=news.getPreview()%>

    <div class="more">
        <a role="button" data-toggle="collapse" href="#collapseExample1<%=i%>" aria-expanded="false" aria-controls="collapseExample1">
            Читати продовження&gt;&gt;
        </a>
    </div>
    <div class="collapse mainCollapse" id="collapseExample1<%=i%>">
        <%=news.getTextBody()%>
    </div>
</div>
<%
        i++;
    }
    sessionFactory.close();
%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">САЙТ ФАЙНОГО МІСТА </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="index.html">Головна</a></li>
                <li><a href="news">Новини</a></li>
                <li><a href="history.html">Історія Тернополя</a></li>
                <li><a href="email.html"><i class="fa fa-envelope-o" aria-hidden="true"></i></a></li>
            </ul>
        </div>
    </div>
</div>

<div id="f">
    <div class="container">
        <div class="row centered">
            <a href="https://vk.com/ternopil" target="_blank"><i class="fa fa-vk"></i></a>
            <a href="https://www.facebook.com/tarnopil" target="_blank"><i class="fa fa-facebook"></i></a>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </div>
    </div>
</div>
<DIV ID = "toTop">Вгору</DIV >
</body>
</html>

