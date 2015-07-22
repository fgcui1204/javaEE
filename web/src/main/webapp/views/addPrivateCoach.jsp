<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>添加私教课</h2>
<form action="/web/users/post" method="post">
    <table>
        <tr>
            <td>顾客</td>
            <td><input type="text" name="customer_name"></td>
        </tr>
        <tr>
            <td>时间</td>
            <td><input type="date" name="time"></td>
        </tr>
        <tr>
            <td>coach</td>
            <td><input type="text" name="text"></td>
        </tr>

    </table>
    <input type="submit" value="确认">
</form>
</body>
</html>
