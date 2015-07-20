
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
</head>
<body>
<%

%>
<h2>注册用户</h2>
<form action="/web/users/register" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="Steven"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="123456"></td>
        </tr>
        <tr>
            <td>角色</td>
            <td><input type="text" name="role" value="Coach"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男" checked>男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="mail" value="steven@gmail.com"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="20"></td>
        </tr>
    </table>
    <input type="submit" value="注册">
</form>
</body>
</html>
