<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/25
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:set var="name" value="${'gareen'}" scope="request"/>

        通过标签获取name: <c:out value="${name}"/> <br>

        通过 EL 获取name: ${name}
    </body>
</html>
