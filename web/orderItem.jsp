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
            window.location.href = "${pageContext.request.contextPath}/orderServlet?dinnerTableId=${dinnerTable.id}&orderId="+orderId+"&method=pay";
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
        .btn{
            background: dodgerblue;
            color: white;
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
<%--<c:if test="${not empty orders}">
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
</c:if>--%>
<div class="container">
    <ul class="list-group">
        <c:if test="${not empty orders}">
            <c:forEach items="${orders}" var="order" varStatus="s">
                <li class="list-group-item">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <h3 class="panel-title" style="width: 200px;">
                                        订单${s.count}
                                    </h3>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <div style="float: right;margin:0 5px">
                                            <button class="btn btn-default" onclick="delOrder(${order.id})">取消订单</button>
                                        </div>
                                        <div style="float: right;margin:0 5px" >
                                            <button class="btn btn-default" onclick="pay(${order.id})">确认付款</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body" style="overflow-y: scroll">
                            <c:if test="${not empty order.orderDetails}">
                                <c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="s">
                                    <div class="row">
                                        <div class="col-xs-3" style="height: 140px;padding: 0 20px 0 20px">
                                            <a href="${pageContext.request.contextPath}/findFoodDetailServlet?dinnerTableId=${dinnerTable.id}&foodID=${orderDetail.food_id}">
                                                <img src="${pageContext.request.contextPath}/upload/food/${orderDetail.food.img}" alt="加载失败" style="width: 150px;height: 150px">
                                            </a>
                                        </div>
                                        <div class="col-xs-9">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    菜品${s.count}：${orderDetail.food.food_name}
                                                </div>
                                                <div class="col-xs-6">
                                                    购买数量：${orderDetail.buyNum}
                                                </div>
                                            </div>
                                            <div class="row">
                                                <ul class="list-group">
                                                    <li class="list-group-item">
                                                        原价：￥${orderDetail.food.price}
                                                    </li>
                                                    <li class="list-group-item">
                                                        折后价：￥<strong style="color: red">${orderDetail.food.price * orderDetail.food.discount}</strong>
                                                    </li>
                                                    <li class="list-group-item">
                                                        共省: ￥${orderDetail.food.price - orderDetail.food.price * orderDetail.food.discount}
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-xs-6">
                                    订单编号：<a>${order.order_code}</a>
                                </div>
                                <div class="col-xs-6" style="text-align: right">
                                    订单日期：<span style="color: dodgerblue">${order.order_Date}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>


</body>
</html>
