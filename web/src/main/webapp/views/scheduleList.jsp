<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <spring:url value="/lib/css/scheduleList.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <%--<link href="./lib/css/scheduleList.css" rel="stylesheet"/>--%>
    <title>课表管理</title>
</head>
<body>

<ul>
    <li>
        <a href="/web/users/session/destroy">注销</a>
    </li>
    <li>
        <a href="/web/users/">用户管理</a>
    </li>
    <li>
        <a href="/web/employees">员工管理</a>
    </li>
    <li>
        <a href="/web/customers">顾客管理</a>
    </li>
    <li>
        <a href="/web/courses">课程管理</a>
    </li>
    <li>
        <a href="/web/schedules">课表管理</a>
    </li>

</ul>

<h1>课表维护</h1>
<table class="schedule_table">
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
