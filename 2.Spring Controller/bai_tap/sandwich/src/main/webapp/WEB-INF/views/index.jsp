<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 01/04/2021
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Choosing</title>
  </head>
  <body>
  <h1>Choosing condiment</h1>
  <form action="/save">
    <input type="checkbox" value="Lettuce" name="condiment">Lettuce
    <input type="checkbox" value="Tomato" name="condiment">Tomato
    <input type="checkbox" value="Mustard" name="condiment">Mustard
    <input type="checkbox" value="Sprouts" name="condiment">Sprouts
    <br>
    <input type="submit" value="Save">
  </form>
  </body>
</html>
