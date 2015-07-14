<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user information</title>
</head>
<body>
<a href="/web/users/session/destroy">注销</a>
<h1>用户信息列表</h1>
<table border="1">
  <thead>
    <th>姓名</th>
    <th>性别</th>
    <th>邮箱</th>
    <th>年龄</th>
    <th>删除</th>
    <th>修改</th>
  </thead>

  <tbody>
<c:forEach items="${userList}" var="user">
  <tr>
    <td>${user.name}</td>
    <td>${user.sex}</td>
    <td>${user.mail}</td>
    <td>${user.age}</td>
    <td><a href="/web/users/delete/${user.userId}">删除</a></td>
    <td><a href="/web/users/${user.userId}">修改</a></td>
  </tr>
</c:forEach>
  </tbody>
  <a href="views/addUser.jsp">添加</a>
</table>
</body>
</html>
