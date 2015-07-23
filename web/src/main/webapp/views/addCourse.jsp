<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>添加课程</h2>
<form action="/web/courses/create" method="post">
    <table>
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="description"></td>
        </tr>
    </table>
    <input type="submit" value="确认">
</form>
</body>
</html>
