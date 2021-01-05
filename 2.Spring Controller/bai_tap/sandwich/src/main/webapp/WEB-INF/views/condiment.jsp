<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 01/05/2021
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sandwich condiment</title>
</head>
<body>
<c:forEach items="${condiment}" var="condiment">
    <h3>${condiment}</h3>
</c:forEach>
</body>
</html>
