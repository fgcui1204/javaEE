<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <title>登录</title>
</head>
<body>
<div class="container col-lg-5 text-center">
<h3 class="text-center">登录</h3>
<form action="/web/users/login" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" placeholder="用户名">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" placeholder="密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
            <a href="../views/register.jsp" class="btn btn-default">注册</a>
        </div>
        <div style="color:red">${message}</div>
    </div>
</form>
</div>
</body>
</html>
