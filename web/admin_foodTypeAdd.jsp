<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/23
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>添加菜品类型</title>

        <!-- 1. 导入CSS的全局样式 -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
        <script src="js/jquery-2.1.0.min.js"></script>
        <!-- 3. 导入bootstrap的js文件 -->
        <script src="js/bootstrap.min.js"></script>

    </head>
<body>
<div class="container" style="width: 300px">
    <center><h3>添加菜品类型</h3></center>
    <form action="${pageContext.request.contextPath}/dinnerTableAddServlet" method="post">
        <div class="form-group">
            <label for="type_name">桌号：</label>
            <input type="text" class="form-control" id="type_name" name="type_name" placeholder="请输入名称">
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
