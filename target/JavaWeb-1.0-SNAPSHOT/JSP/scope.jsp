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
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    pageContext域:<%=pageContext.getAttribute("key")%><br>
    request:<%=request.getAttribute("key")%><br>
    session:<%=session.getAttribute("key")%><br>
    application:<%=application.getAttribute("key")%><br>

    <%
        //request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>

    <%--
         <jsp:forward page=" "></jsp:forward>  是请求转发标签,它的功能就是请求转发
         page 属性设置请求转发的路径
    --%>
    <jsp:forward page="/JSP/scope2.jsp"></jsp:forward>


</body>
</html>
