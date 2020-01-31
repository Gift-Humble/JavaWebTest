<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/23
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>test1</title>
    </head>
    <body>
        Test1
        <br>
        <%= new Date() %>
        <br>
        <%= "hello jsp" %><br>
        <%for (int s : new int[]{1, 2, 3}) { %>
        <%= s %>
        <% } %>
        <br>
        page:<%=page%>
        <br>
        this:<%=this%>
        <br>
        <%
            if(true){
                out.println(123);
            }
        %>
    </body>
</html>
