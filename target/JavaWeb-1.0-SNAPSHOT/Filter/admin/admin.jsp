<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/10
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            System.out.println("admin.jsp页面执行了");
            Object user = session.getAttribute("user");
            //如果等于null,说明还没有登录
            if (user == null) {
                request.getRequestDispatcher("/Filter/login.jsp").forward(request, response);
                return;
            }

        %>
    我是admin.jsp文件

</body>
</html>
