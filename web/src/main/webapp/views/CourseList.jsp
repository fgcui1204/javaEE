<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="/web/users/session/destroy">注销</a>
<a href="/web/users/">用户管理</a>
<a href="/web/coaches">员工管理</a>
<a href="/web/users/session/destroy">Customer管理</a>
<a href="/web/courses">课程管理</a>
<a href="/web/users/session/destroy">添加私教</a>

<h1>课程维护</h1>
<table border="1">
    <thead>
    <th>名称</th>
    <th>Coach</th>
    <th>时间</th>
    <th>删除</th>
    <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${courseList}" var="course">
        <tr>
            <td>${course.name}</td>
            <td>${course.employee.name}</td>
            <td>${course.time}</td>
            <td><a href="/web/employees/delete/${course.id}">删除</a></td>
            <td><a href="/web/employees/${course.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
