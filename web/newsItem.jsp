<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/21
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <title>新闻中心</title>
    <link href="css/news.css" rel="stylesheet" type="text/css" />

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

<div id="container"  >
    <div class="wrapper">
        <!-- wrapper start-->

        <!--MainBlock start-->
        <div class="cbox" >
            <div class="lbox" >
                <div class="ttitle" >
                    <ul>
                        <li class="btl"></li>
                        <li class="btm2" id="title">
                            <span><fmt:formatDate value="${newsDetail.update_date}" pattern="yyyy-MM-dd"/></span>
                            ${newsDetail.title}
                        </li>
                        <li class="btr"></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="mcon">
                    <div class="newsdetail" id="info">
                        <p style="text-align: center;">
                            <strong>${newsDetail.title}</strong>
                        </p>
                        <p>
                            ${newsDetail.content}
                        </p>


                    </div>
                </div>
                <div class="dborder">
                    <div class="bdl"></div>
                    <div class="bdr"></div>
                </div>
            </div>


            <div class="rbox">
                <div class="downview">
                    <div class="ttitle">
                        <ul>
                            <li class="btl"></li>
                            <li class="btm2">新闻列表</li>
                            <li class="btr"></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="mcon">
                        <div class="rnewslist" id="list">
                            <ul>

                                <c:forEach items="${news}" var="neww">
                                    <li class="cline1"><a href="${pageContext.request.contextPath}/newsFindServlet?method=homefind&newsId=${neww.id}">${neww.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="rpages">
                            <div class="btn_nums" id="rnums"></div>
                        </div>
                    </div>
                    <div class="dborder">
                        <div class="bdl"></div>
                        <div class="bdr"></div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <!--MainBlock end-->

    </div>
    <!-- wrapper end-->

    <br>
    <br>
    <!--bottomInfo end-->
    <div class="toolbar">
        <!--toolabr start-->
    </div>
    <!--toolabr end-->


</div>




</body>
</html>

