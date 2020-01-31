<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/24
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String) session.getAttribute("name");
%>
<html>
    <head>
        <title>getSession</title>
    </head>
    <body>
        session中的name: <%= name%>
    </body>
</html>
