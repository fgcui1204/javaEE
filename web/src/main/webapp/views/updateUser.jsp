<%--
  Created by IntelliJ IDEA.
  User: fgcui
  Date: 7/8/15
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <tr>
            <td>性别</td>
            <td>
                <c:if test="${user.sex=='男'}">
                    <input type="radio" name="sex" value="男" checked>男
                    <input type="radio" name="sex" value="女"} >女
                </c:if>
                <c:if test="${user.sex=='女'}">
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女" checked >女
                </c:if>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="mail" value="${user.mail}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${user.age}"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
