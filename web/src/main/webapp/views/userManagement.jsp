<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user information</title>
</head>
<body>
<a href="/web/users/session/destroy">注销</a>
<a href="/web/users">用户管理</a>
<a href="/web/employees">员工管理</a>
<a href="/web/customers">Customer管理</a>
<a href="/web/courses">课程管理</a>
<a href="/web/schedules">课表管理</a>
<a href="/web/users/session/destroy">添加私教</a>

<h1>用户信息列表</h1>
<table border="1">
    <thead>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>删除</th>
        <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><a href="/web/users/delete/${user.id}">删除</a></td>
            <td><a href="/web/users/${user.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
