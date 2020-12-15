<%@page language="java" contentType="text/html; character = UTF-8" pageEncoding="utf-8" %>

<html>
<head>
    <title>菜品详情</title>


    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <link href="css/foodDetail.css" type="text/css" rel="stylesheet">

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
                <li><a href="${pageContext.request.contextPath}/orderServlet?dinnerTableId=${dinnerTable.id}&method=checkOrder">我的订单</a></li>
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


<div class="mid">
    <div class="per-mid-h">
        <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
        >
        <a href="#" class="c_66">菜品详情</a>
        >
        <a href="#" class="c_66">${sceniceDetail.scenic_name}</a>
    </div>
    <div class="per-mid-m" >
        <div class="picture">
            <div class="picture-1">
                <img src="${sceniceDetail.url1}">
            </div>
        </div>
        <div class="scenicDet">
            <h3>
                <i>${sceniceDetail.scenic_name}</i>
            </h3>
            <div class="mid-r-m">
                <span class="bianhao">编号&nbsp;:&nbsp;GZ0001</span>
                <span class="fengefu"></span>
                <span class="destin">目的地&nbsp;:&nbsp;上海</span>
            </div>
            <div>
                <table>
                    <tr>
                        <td style="width: 100px">旅游类型</td>
                        <td style="width: 300px">单人游</td>
                    </tr>
                    <tr>
                        <td>行程天数</td>
                        <td>1天</td>
                    </tr>
                    <tr>
                        <td>联系电话</td>
                        <td>1111111111</td>
                    </tr>
                </table>
            </div>
            <div class="scenic-price">
                <font>
                    价格:
                </font>
                <font>
                    ￥${sceniceDetail.scenic_price.scenic_price/10*sceniceDetail.scenic_price.scenic_zk}
                </font>
            </div>
            <div class="buy-button">
                <button type="button" class="btn btn-outline-success" onclick="xadmin.open('预订景点票', '${ctx}/uSceninc/toScenicBuy?id=${sceniceDetail.id}',600,800)">预订</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
