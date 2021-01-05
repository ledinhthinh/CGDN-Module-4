<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 12/31/2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h2>USD to VND</h2>
    <form method="get" action="/math">
    <input value="${usd}" type="text" name="usd">
    <button type="submit">submit</button>
    </form>
    VND:${vnd}
</body>
</html>
