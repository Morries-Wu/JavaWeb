<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/7
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //往四个域中都分别保存了数据
    %>
    pageContext:<%=pageContext.getAttribute("key")%><br>
    request:<%=request.getAttribute("key")%><br>
    session:<%=session.getAttribute("key")%><br>
    application:<%=application.getAttribute("key")%><br>



</body>
</html>
