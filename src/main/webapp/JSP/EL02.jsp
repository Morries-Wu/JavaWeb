<%@ page import="Com.Bean.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/7
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("祥哥还行");
    person.setPhones(new String[]{"10086", "1008611", "1008451"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("广州");
    person.setCities(cities);
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    person.setMap(map);

    pageContext.setAttribute("person", person);
%>


输出Person:${person}<br>
输出Person的name属性:${person.name}<br>
输出Person的phones属性:${person.phones[0]}<br>
输出Person的cities集合属性:${person.cities}<br>
输出Person的map集合属性:${person.map.key3}<br>


</body>
</html>
