<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/4
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        //付款
        function pay(orderId){
            window.location.href = "${pageContext.request.contextPath}/orderServlet?orderId="+orderId+"&method=pay";
            alert("付款成功！欢迎下次光临！")

            //付款完成，取消占位
        }

    </script>


    <style>
        img {
            object-fit: cover;
        }

        .col-xs-4 {
            overflow: hidden;
            margin: 0;
        }

        .list1 > div > ul > li > a {
            text-align: center;
            color: black;
        }
        .col-xs-2{
            padding: 0;
        }
        .nothing{
            height: 50px;
            background:#1C1C1C;
            margin-top: 10px;
            border-radius: 6px;
        }
        .nothing>div>div>h1{
            color: gray;
            font-size: small;
        }
    </style>
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
                <li><a href="#">入口三</a></li>
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
<c:if test="${not empty orders}">
    <c:forEach items="${orders}" var="order" varStatus="s">
        <br>
        <p style="color: red">订单${s.count}------------------------------------------------------------------------------------------</p>
        订单编号：${order.order_code}
        <br>
        下单时间：${order.order_Date}
        <br>
        -----------------------------------------------------------------------------------------------
        <br>
        <c:if test="${not empty order.orderDetails}">
            <c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="s">
                菜品${s.count}：${orderDetail.food.food_name}<br>
                ----------购买数量：${orderDetail.food.buyNum}
                ----------原价：<s>${orderDetail.food.price}</s>
                -----折后价：<strong>${orderDetail.food.price * orderDetail.food.discount}</strong>
                <br>
            </c:forEach>
            总价：${order.total_Price}元<br>
            <input type="button" onclick="pay(${order.id})" value="付款">
            <input type="button" onclick="delOrder(${order.id})" value="取消订单">
        </c:if>
    </c:forEach>
</c:if>



</body>
</html>
