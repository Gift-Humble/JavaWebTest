<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/24
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>getContext</title>
    </head>
    <body>
        <%=pageContext.getAttribute("name")%>
        <%=request.getAttribute("bbb")%>
        <%=session.getAttribute("session")%>
        <%=application.getAttribute("app")%>
    </body>
</html>
