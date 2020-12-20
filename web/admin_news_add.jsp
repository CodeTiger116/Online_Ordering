<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/20
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 500px">
    <center><h3>发布通知</h3></center>
    <form action="${pageContext.request.contextPath}/newsAddServlet" method="post">
        <div class="form-group">
            <label for="title">标题：</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
        </div>

        <div class="form-group">
            <label for="content">内容：</label>
            <%--<input type="text" class="form-control" id="content" name="content" placeholder="请输入桌号">--%>
            <textarea class="form-control" id="content" name="content" cols="5" rows="20" >请输入内容</textarea>
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
