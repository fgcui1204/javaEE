<%--
  Created by IntelliJ IDEA.
  User: fgcui
  Date: 7/13/15
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>登录</h1>
<form action="../users/login" method="post">
    <table>
        <tr>
            <td>用户：</td>
            <td><input type="input" name="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
        <tr>
            <td colspan="2" style="color:red">${message}</td>
        </tr>
    </table>

</form>
</body>
</html>
