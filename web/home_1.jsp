<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/2
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选择餐桌</title>
    <link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>

<nav class="navbar navbar-inverse" role="navigation" id="mynav" style="margin: 0">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">
                订餐系统
            </a>
            <span></span>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/index_1Servlet">选择餐桌</a></li>
                <li><a href="${pageContext.request.contextPath}/indexServlet">主页</a></li>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown">
                        用户
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人中心</a></li>
                        <li><a href="#">购物车</a></li>
                        <li><a href="#">设置</a></li>
                        <li class="divider"></li>
                        <li><a href="#">退出登录</a></li>
                    </ul>
                </li>
                <li><a href="#">商家中心</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="list1 panel panel-default col-xs-6" style="height: auto">
            <div class="panel-heading" style="text-align: center;">可用餐桌</div>
            <div class="panel-body" style="height:400px">
                <ul class="nav nav-pills nav-stacked ">
                    <c:forEach items="${dinnerTables}" var="dinnerTable" varStatus="s">
                        <c:if test="${not empty dinnerTables}">
                            <li><a href="${pageContext.request.contextPath}/indexServlet?userID=${user.ID}&id=${dinnerTable.id}">${dinnerTable.table_Name}</a></li>
                        </c:if>
                    </c:forEach>


                </ul>

            </div>

        </div>
        <div class="list1 panel panel-default col-xs-6">
            <div class="panel-heading" style="text-align: center;">正在使用的餐桌</div>
            <div class="panel-body" style="height:400px">
                <ul class="nav nav-pills nav-stacked ">
                    <c:forEach items="${dinnerTables_1}" var="dinnerTable_1" varStatus="s">
                        <c:if test="${not empty dinnerTables_1}">
                            <li><a href="${pageContext.request.contextPath}/indexServlet?id=${dinnerTable_1.id}">${dinnerTable_1.table_Name}</a></li>
                        </c:if>
                    </c:forEach>


                </ul>

            </div>

        </div>
    </div>

</div>




</body>
</html>
