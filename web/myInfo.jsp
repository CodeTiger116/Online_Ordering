<%--
  Created by IntelliJ IDEA.
  User: JiuCaiHeZi
  Date: 2020/12/24
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        #me_header {
            background-image: url("images/rg_layout.jpg");
            width: 100%;
            height: 150px;
        }
    </style>
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
                <li><a href="${pageContext.request.contextPath}/indexServlet">主页</a></li>
                <li>
                    <a href="${pageContext.request.contextPath}/orderServlet?dinnerTableId=${dinnerTable.id}&method=checkOrder">我的订单</a>
                </li>
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
                        <li><a href="#">购物车</a></li>
                        <li><a href="#">设置</a></li>
                        <li class="divider"></li>
                        <li><a href="#">退出登录</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/admin_login.jsp">商家中心</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12" id="me_header">
            <div class="row" style="padding-top:40px ">
                <div class="col-xs-2"></div>
                <div class="col-xs-1">
                    <a href="#"><img class="img-circle" src="images/header.jpg" alt="头像"
                                     style="height: 70px;width: 70px"></a>
                </div>
                <div class="col-xs-9">
                    <div class="row">
                        <div style="height: 30px;color: white">
                            <H4>用户名&nbsp:<span>&nbsp${user.LOGIN_NAME}</span></H4>
                        </div>
                    </div>
                    <div class="row">
                        <div style="height: 30px;color: white">
                            <H4>ID:${user.ID}</H4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div>
        <div class="row" style="height: 500px">
            <div class="col-xs-2" style="padding: 0;">
                <div class="well" style="height:100%">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active">
                            <a >个人资料</a>
                        </li>
                        <li >
                            <a >账号设置</a>
                        </li>
                        <li >
                            <a >
                                我的标签
                            </a>
                        </li>
                        <li >
                            <a>关注的人</a>
                        </li>
                    </ul>
                </div>

            </div>
            <div class="col-xs-10" style="padding: 0">
                <div class="panel panel-default" style="height: 100%">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-6 pull-left">
                                <span class="panel-title">账号信息</span>
                            </div>
                            <div class="pull-right" style="padding-right: 10px">
                             <a class="btn btn-default" role="button" style="background: dodgerblue;color: white">点击修改</a>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td>ID:</td>
                                <td>${user.ID}</td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>${user.LOGIN_NAME}</td>
                            </tr>
                            <tr>
                                <td>真实姓名：</td>
                                <td>${user.realName}</td>
                            </tr>
                            <tr>
                                <td>性别</td>
                                <td>${user.gender}</td>
                            </tr>
                            <tr>
                                <td>生日：</td>
                                <td>${user.birthday}</td>
                            </tr>
                            <tr>
                                <td>电话：</td>
                                <td>${user.PHONE}</td>
                            </tr>
                            <tr>
                                <td>电子邮箱：</td>
                                <td>${user.EMAIL}</td>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
