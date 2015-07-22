<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>修改课表</title>
</head>
<body>
<h2>修改课表</h2>
<form action="/web/schedules/create" method="post">
    <table>
        <tr>
            <td>课程名称</td>
            <td>
                <select name="courseId">
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>时间</td>
            <td><input type="date" name="day" value="${schedule.day}"></td>
        </tr>
        <tr>
            <td>coach</td>
            <td>
                <select name="coachId">
                    <c:forEach items="${coaches}" var="coach">
                        <option value="${coach.id}">${coach.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

    </table>
    <input type="submit" value="确认">
</form>

</body>
</html>
