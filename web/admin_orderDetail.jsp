<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/24
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

<div class="container" style="margin-top: 20px">
    <ul class="list-group">
        <c:if test="${not empty orders}">
                <li class="list-group-item">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <h3 class="panel-title" style="width: 200px;">
                                        订单详情
                                    </h3>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <div style="float: right;margin:0 5px">
                                            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/orderFindByPageServlet">返回</a>
                                        </div>
                                       <%-- <div style="float: right;margin:0 5px" >
                                            <button class="btn btn-default" onclick="pay(${order.id})">确认付款</button>
                                        </div>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body" style="overflow-y: scroll">
                            <%--<c:if test="${not empty orders.OrderDetail}">--%>
                                <c:forEach items="${orders}" var="orderDetail" varStatus="s">
                                    <div class="row">
                                        <div class="col-xs-3" style="height: 140px;padding: 0 20px 0 20px">
                                            <a href="#">
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

        <%--</c:if>--%>
    </ul>
</div>


</body>
</html>
