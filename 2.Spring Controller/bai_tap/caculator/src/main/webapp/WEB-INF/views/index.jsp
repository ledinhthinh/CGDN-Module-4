<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 01/05/2021
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculating">
  <input type="number" name="num1" placeholder="the first number" value="${num1}">
  <input type="number" name="num2" placeholder="the second number" value="${num2}">
  <br><br>
  <input type="submit" name="operator" value="+">
  <input type="submit" name="operator" value="-">
  <input type="submit" name="operator" value="X">
  <input type="submit" name="operator" value="/">
</form>
<c:if test="${result != null}"><h3>Result ${result}</h3></c:if>
</body>
</html>
