<%--
  Created by IntelliJ IDEA.
  User: JiuCaiHeZi
  Date: 2020/12/20
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论区</title>
    <script src='//unpkg.com/valine/dist/Valine.min.js'></script>



    <link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>

<nav class="navbar navbar-inverse" role="navigation" id="mynav" style="margin: 0">
    <div class="container ">
        <div class="navbar-header">
            <a class="navbar-brand">
                订餐系统
            </a>
            <span></span>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/index_1Servlet">选择餐桌</a></li>
                <li><a href="${pageContext.request.contextPath}/indexServlet?id=${dinnerTable.id}">主页</a></li>
                <li>
                    <a href="${pageContext.request.contextPath}/orderServlet?dinnerTableId=${dinnerTable.id}&method=checkOrder">我的订单</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/newsFindServlet?method=homefind">新闻中心</a></li>
                <li><a href="${pageContext.request.contextPath}/commentList_2.jsp">评论区</a></li>
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
                        <li><a href="${pageContext.request.contextPath}/findUserServlet?id=${user.ID}">个人中心</a></li>
                        <%--<li><a href="#">购物车</a></li>--%>
                        <%--<li><a href="#">设置</a></li>--%>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/userLogOfServlet">退出登录</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/admin_login.jsp">商家中心</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div id="vcomments"></div>
    </div>
</div>
<script>
    new Valine({
        el: '#vcomments',
        appId: 'baYuHfNAb3ljpHR50f10Wyrg-gzGzoHsz',
        appKey: 'EowIeoGnkXtGE6rGTCzGDVHc',
        meta:['nick']
    })
</script>
</body>
</html>
