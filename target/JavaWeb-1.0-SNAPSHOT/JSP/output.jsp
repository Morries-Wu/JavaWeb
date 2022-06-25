<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/7
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        response.getWriter().write("response输出1<br>");
        response.getWriter().write("response输出2<br>");

        out.write("out输出1<br>");
        out.write("out输出2<br>");
        request.setAttribute("key","value");
    %>

    表达式脚本输出的key的值是:<%=request.getAttribute("key")%><br>
    EL表达式输出key的值是:${key}



</body>
</html>
