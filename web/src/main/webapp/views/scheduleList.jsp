<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>课表管理</title>
</head>
<body>

<a href="/web/users/session/destroy">注销</a>
<a href="/web/users/">用户管理</a>
<a href="/web/employees">员工管理</a>
<a href="/web/users/session/destroy">Customer管理</a>
<a href="/web/courses">课程管理</a>
<a href="/web/schedules">课表管理</a>
<a href="/web/users/session/destroy">添加私教</a>

<h1>课表维护</h1>
<table border="1">
    <thead>
    <th>时间</th>
    <th>课程名称</th>
    <th>教练</th>

    <th>删除</th>
    <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${scheduleList}" var="schedule">
        <tr>
            <td>${schedule.day}</td>
            <td>${schedule.course.name}</td>
            <td>${schedule.employee.name}</td>
            <td><a href="/web/schedules/delete/${schedule.id}">删除</a></td>
            <td><a href="/web/schedules/update/${schedule.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/web/schedules/create">添加课表</a>
</body>
</html>
