<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/7
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        头部信息<br>
        主题内容<br>
        <%--
        <%@include file="/JSP/footer.jsp"%>  就是静态包含
        file 属性指定你要包含的jsp页面的路径
        地址中的第一个斜杠/  表示为http://ip:port/工程路径/映射到代码的目录

        静态包含的特点:
        1、静态包含不会翻译被包含的jsp页面
        2、静态包含其实就是把被包含的jsp页面的代码拷贝到包含的位置执行输出
        --%>


        <%--
         <jsp:include page="/JSP/footer.jsp"></jsp:include>
         这是动态包含
         page 属性是指定你要包含的jsp页面的路径
         动态包含也可以像静态包含一样,把被包含的内容执行输出到包含位置
         动态包含特点:
         1、动态包含也会把被包含的jsp页面翻译成为Java代码
         2、动态代码底层代码使用
        --%>

        <jsp:include page="/JSP/footer.jsp">
            <jsp:param name="username" value="morries_Wu"/>
            <jsp:param name="root" value="root"/>
        </jsp:include>

</body>
</html>
