<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>修改课程信息</h2>
<form action="/web/courses/update" method="post">
    <input type="hidden" name="id" value="${course.id}">
    <table>
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="name" value="${course.name}"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="description" value="${course.description}"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
