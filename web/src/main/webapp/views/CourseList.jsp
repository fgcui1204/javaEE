<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<html>
<head>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <title>课程列表</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/web/employees">员工管理 <span class="sr-only">(current)</span></a>
                </li>
                <li class="active"><a href="/web/courses">课程管理</a></li>
                <li><a href="/web/schedules">课表管理</a></li>
                <li><a href="/web/schedules">添加私教课</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/web/users/session/destroy">注销</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<%--<a href="/web/users/session/destroy">注销</a>--%>
<%--<a href="/web/users/">用户管理</a>--%>
<%--<a href="/web/employees">员工管理</a>--%>
<%--<a href="/web/users/session/destroy">Customer管理</a>--%>
<%--<a href="/web/courses">课程管理</a>--%>
<%--<a href="/web/schedules">课表管理</a>--%>
<%--<a href="/web/users/session/destroy">添加私教</a>--%>

<h1>课程维护</h1>

<table border="1">
    <thead>
    <th>编号</th>
    <th>名称</th>
    <th>描述</th>
    <th>删除</th>
    <th>修改</th>
    </thead>

    <tbody>
    <c:forEach items="${courseList}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.description}</td>
            <td><a href="/web/courses/delete/${course.id}">删除</a></td>
            <td><a href="/web/courses/update/${course.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/addCourse.jsp">添加课程</a>
</body>
</html>
