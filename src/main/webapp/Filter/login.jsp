<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/10
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    这是登录页面login.jsp页面<br>
    <form action="http://localhost:8080/JavaWeb/filterlogin" method="post">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" name="提交">
    </form>
</div>
</body>
</html>
