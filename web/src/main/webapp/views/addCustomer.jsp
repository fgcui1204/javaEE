<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <title>添加顾客</title>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">添加顾客</h3>
        </div>
        <div class="panel-body">

            <form action="/web/customers/create" method="post">
                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" class="form-control" name="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label>电话</label>
                    <input type="text" class="form-control" name="telphone" placeholder="电话">
                </div>

                <button type="submit" class="btn btn-default">确认</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
