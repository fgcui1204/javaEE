<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <title>user information</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/web/employees">员工管理</a>
                    </li>
                    <li>
                        <a href="/web/courses">课程管理</a>
                    </li>
                    <li class="active">
                        <a href="/web/users">用户管理</a>
                    </li>
                    <li>
                        <a href="/web/schedules">课表管理</a>
                    </li>
                    <li>
                        <a href="/web/customers">顾客管理</a>
                    </li>
                    <li>
                        <a href="/web/private/course/create">添加私教课</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/web/users/session/destroy">注销</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
<h1>用户信息列表</h1>
<table  class="table table-striped table-bordered table-condensed">
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
            <td><a href="/web/users/delete/${user.id}" class="btn btn-primary">删除</a></td>
            <td><a href="/web/users/${user.id}" class="btn btn-primary">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
