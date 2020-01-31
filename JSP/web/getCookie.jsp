<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            out.print(cookies[i].getName() + "：" + cookies[i].getValue() + "<br>");
        }
    }
%>
<html>
    <head>
        <title>getCookie</title>
    </head>
    <body>
        getCookie
    </body>
</html>
