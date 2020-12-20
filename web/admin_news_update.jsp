<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/20
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container" style="width: 500px">
    <center><h3>修改通知</h3></center>
    <form action="${pageContext.request.contextPath}/newsUpdateServlet" method="post">

        <!--隐藏域，提交id-->
        <input type="hidden" name = "id" value="${news.id}">

        <div class="form-group">
            <label for="title">标题：</label>
            <input type="text" class="form-control" id="title" name="title" value="${news.title}">
        </div>

        <div class="form-group">
            <label for="content">内容：</label>
            <textarea class="form-control" id="content" name="content" cols="5" rows="20" >${news.content}</textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>

</body>
</html>
