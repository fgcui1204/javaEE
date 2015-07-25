<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="/web/users/session/destroy">注销</a>
<a href="/web/employees">员工管理</a>
<a href="/web/customers">Customer管理</a>
<a href="/web/courses">课程管理</a>
<a href="/web/schedules">课表管理</a>
<a href="/web/users/session/destroy">添加私教</a>

<h1>员工信息维护</h1>
<table border="1">
    <thead>
    <th>姓名</th>
    <th>邮箱</th>
    <th>性别</th>
    <th>年龄</th>
    <th>角色</th>
    <th>删除</th>
    <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.mail}</td>
            <td>${employee.sex}</td>
            <td>${employee.age}</td>
            <td>${employee.role}</td>
            <td><a href="/web/employees/delete/${employee.id}">删除</a></td>
            <td><a href="/web/employees/update/${employee.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/register.jsp">添加员工</a>
</body>
</html>
