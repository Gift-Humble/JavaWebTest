<%--
  Created by IntelliJ IDEA.
  User: SKYTR
  Date: 2020/1/25
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>listHero</title>
    </head>
    <body>
        <table align="center" border="1" cellspacing="0">
            <tr>
                <td>id</td>
                <td>name</td>
            </tr>
            <c:forEach items="${heros}" var="hero" varStatus="st">
                <tr>
                    <td>${hero.id}</td>
                    <td>${hero.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
