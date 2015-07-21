<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="/web/users/session/destroy">注销</a>
<h1>用户信息列表</h1>
<table border="1">
    <thead>
    <th>姓名</th>
    <th>邮箱</th>
    <th>角色</th>
    <th>删除</th>
    <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${coachList}" var="coach">
        <tr>
            <td>${coach.name}</td>
            <td>${coach.mail}</td>
            <td>${coach.role}</td>
            <td><a href="/web/users/delete/${coach.id}">删除</a></td>
            <td><a href="/web/users/${coach.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
