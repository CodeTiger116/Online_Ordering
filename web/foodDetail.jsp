<%@page language="java" contentType="text/html; character = UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <script type="text/javascript">
        //加入购物车
        function  addShopCar(foodId){
            //foodTypeId   //刷新界面后为当前菜品类型
            //加入商品到购物车，需要知道foodId  dinnerTableId
            window.location.href = "${pageContext.request.contextPath}/shopCarServlet?dinnerTableId=${dinnerTableId}&foodId=${food.id}&method=add";
        }

    </script>

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
                <%--<li><a href="${pageContext.request.contextPath}/indexServlet">主页</a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/orderServlet?dinnerTableId=${dinnerTable.id}&method=checkOrder">我的订单</a></li>--%>
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
        <a href="#" class="c_66">${food.food_name}</a>
    </div>
    <div class="per-mid-m" >
        <div class="picture">
            <div  class="picture-1" style="border: solid 1px; overflow: hidden">
                <img src="${pageContext.request.contextPath}/upload/food/${food.img}">
            </div>
        </div>
        <div class="scenicDet">
            <h3>
                <i>${sceniceDetail.scenic_name}</i>
            </h3>

            <div>
                <table>
                    <tr>
                        <td style="width: 100px">名称：</td>
                        <td style="width: 300px">${food.food_name}</td>
                    </tr>
                    <tr>
                        <td>描述：</td>
                        <td>${food.remark}</td>

                    </tr>
                </table>
            </div>
            <div class="scenic-price">
                <td>价格：</td>
                <td><a><s>￥${food.price}</s> &nbsp;&nbsp;&nbsp; <strong>￥${food.price * food.discount}</strong></a></td>
            </div>
            <div class="buy-button">
                <button type="button" onclick="addShopCar()" class="btn btn-outline-success" >加入购物车</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
