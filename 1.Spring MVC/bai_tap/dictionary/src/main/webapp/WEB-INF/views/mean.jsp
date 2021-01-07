<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 01/07/2021
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translation</title>
</head>
<body>
<c:if test="${mean != null}">
    <h1>${keyword}----------- Vietnamese: ${mean}</h1>
</c:if>
<c:if test="${mean == null}">
    <h1>Not exist keyword</h1>
</c:if>
</body>
</html>