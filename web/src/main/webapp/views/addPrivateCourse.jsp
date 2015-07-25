<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <td>
                <select name="customer">
                    <c:forEach items="${customers}" var="customer">
                        <option>${customer.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>时间</td>
            <td><input type="date" name="time"></td>
        </tr>
        <tr>
            <td>coach</td>
            <td>
                <select name="coach">
                    <c:forEach items="${coaches}" var="coach">
                        <option>${coach.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

    </table>
    <input type="submit" value="确认">
</form>
</body>
</html>
