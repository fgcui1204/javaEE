<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<h2>修改用户信息</h2>
<form action="/web/users/put" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${user.password}"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
