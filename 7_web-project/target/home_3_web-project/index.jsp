<%--
  Created by IntelliJ IDEA.
  User: DIMA
  Date: 24.06.2020
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web-project</title>
</head>
<body>

<form action="/registration" method="post">
    <label>Project name : </label><input type="text" name="name"><br>
    <label>Budget : </label><input type="number" name="budget"><br>
    <label>Email : </label><input type="email" name="email"><br>
    <label>Password : </label><input type="password" name="password"><br>
    <input type="submit" value="Ok">
</form>

</body>
</html>
