<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/24
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie c = new Cookie("name", "Gareen");
    c.setMaxAge(60 * 24 * 60);
    c.setPath("/");
    response.addCookie(c);
%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="getCookie.jsp">跳转到获取cookie的页面</a>
    </body>
</html>
