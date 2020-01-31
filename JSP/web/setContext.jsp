<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/24
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("name", "linpei");
    request.setAttribute("bbb","ccc");
    session.setAttribute("session","linpei");
    application.setAttribute("app","peige");
%>
<html>
    <head>
        <title>setContext</title>
    </head>
    <body>
        <%=pageContext.getAttribute("name")%>
<%--        <%=request.getAttribute("bbb")%>--%>
<%--        <jsp:forward page="getContext.jsp"/>--%>
        <%
            response.sendRedirect("getContext.jsp");
        %>
        <%
            System.out.println(application == request.getServletContext());
        %>
    </body>
</html>
