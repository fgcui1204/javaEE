<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>修改员工信息</h2>
<form action="/web/employees/update" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${employee.name}"></td>
        </tr>
        <tr>
            <td>角色</td>
            <td>
                <select name="role">
                    <option value="Coach">Coach</option>
                    <option value="HR">HR</option>
                    <option value="OPs">OPs</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="mail" value="${employee.mail}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${employee.age}"></td>
        </tr>
    </table>
    <input type="submit" value="确定">
</form>
</body>
</html>
