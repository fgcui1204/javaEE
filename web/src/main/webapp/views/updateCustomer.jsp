<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>修改顾客信息</h2>
<form action="/web/customers/update" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${customer.name}"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="telphone" value="${customer.telphone}"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
