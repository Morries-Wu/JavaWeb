<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/10
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp页面执行了");
        System.out.println("target.jsp页面" + Thread.currentThread().getName());
    %>

</body>
</html>
