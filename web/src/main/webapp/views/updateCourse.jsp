<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <spring:url value="/lib/js/updateCourse.js" var="updateCourse"/>
    <script src="${updateCourse}"></script>
    <%--<script src="/web/lib/js/updateCourse.js"></script>--%>
    <title>修改课程信息</title>
</head>
<body>
<h2>修改课程信息</h2>
<form id="update_course">
    <input type="hidden" name="id" id="courseId" value="${course.id}">
    <table>
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="name" id="name" value="${course.name}"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="description" id="description" value="${course.description}"></td>
        </tr>
    </table>
    <input type="submit" value="修改" class="update_course">
</form>
</body>
</html>
