<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/19
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>后台管理</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>


<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"/>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>--%>





    <style>
        a {
            color: white;
            text-align: center;
            width: 100%;
        }

        #settings > li > a {
            color: white;
        }

        #interior {
            overflow: scroll;
        }
    </style>


</head>
<body>

<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0;background: #007aff">
    <div class="container-fluid">
        <div class="navbar-header col-xs-2">
            <a class="navbar-brand" href="#" style="color: white">管理员操作系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right" id="settings">
                <li><a href="#">设置</a></li>
                <li><a href="#">回到主页</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row" style="height: 100%">
        <div class="col-xs-2" style="height: 610px; background-color: dodgerblue">
            <ul class="nav nav-pills nav-stacked guide">
                <li><a href="${pageContext.request.contextPath}/userListServlet" id="one">用户信息</a></li>
                <li><a href="${pageContext.request.contextPath}/dinnerTableFindByPageServlet" id="two">餐桌管理</a></li>
                <li><a href="${pageContext.request.contextPath}/foodTypeListServlet" id="three">菜系管理</a></li>
                <li><a href="${pageContext.request.contextPath}/foodFindByPageServlet" id="four">菜品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/orderFindByPageServlet" id="five">订单管理</a></li>

            </ul>
        </div>
        <div class=""  style="height: 100% ;border: solid 1px" id="interior">
            <jsp:include page="${mainRight==null?'blank.jsp':mainRight}"></jsp:include>
        </div>
    </div>
</div>



</body>
</html>
