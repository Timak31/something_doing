<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: timla
  Date: 11.10.2018
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
    <div>
        <h1>List page!</h1>
    </div>

    <div>
        <div>
            <div>
                <h2>Users</h2>
            </div>
            <%
                List<String> names = (List<String>) request.getAttribute("userNames");

                if (names != null && !names.isEmpty()) {
                    out.println("<ui>");
                    for (String s : names) {
                        out.println("<li>" + s + "</li>");
                    }
                    out.println("</ui>");
                } else out.println("<p>There are no users yet!</p>");
            %>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
