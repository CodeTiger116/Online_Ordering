<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/17
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>

    <%--<!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>--%>


    <link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <script type="text/javascript">
        function  addShopCar(foodId){
            var dinnerTableId = $("#dinnerTableId").val();
            //foodTypeId   //刷新界面后为当前菜品类型
            var foodTypeId = $("#foodTypeId").val();
            //加入商品到购物车，需要知道foodId  dinnerTableId
            window.location.href = "${pageContext.request.contextPath}/shopCarServlet?dinnerTableId="+dinnerTableId+"&foodId="+foodId+"&foodTypeId="+foodTypeId+"&method=add";
        }

        //购买数量输入框失去焦点事件
        function blurFn(obj, foodId ,buyNum, dinnerTableId,foodTypeId){
            //获取用户输入的对象
            var num = obj.value;

            //如果用户输入不符合规范，输入框值不变
            if(num < 1 || isNaN(num)){
                obj.value = buyNum;
            }else if(num !== buyNum){
                window.location.href ="${pageContext.request.contextPath}/shopCarServlet?foodId="+foodId+"&dinnerTableId="+dinnerTableId+"&buyNum="+Math.ceil(num)+"&foodTypeId="+foodTypeId+"&method=update";
            }
        }


        //删除购物车的菜品
        function deleteFn(dinnerTableId,foodId,foodTypeId){
            window.location.href ="${pageContext.request.contextPath}/shopCarServlet?dinnerTableId="+dinnerTableId+"&foodId="+foodId+"&foodTypeId="+foodTypeId+"&method=delete";
        }

        //占位/取消占位
        function orderDinner(dinnerTableId,tableStatus){
            window.location.href ="${pageContext.request.contextPath}/dinnerTableStatusServlet?dinnerTableId="+dinnerTableId+"&tableStatus="+tableStatus;
        }

        //下单
        function order(dinnerTableId){
            if(${total != 0}){
                window.location.href ="${pageContext.request.contextPath}/orderServlet?dinnerTableId="+dinnerTableId+"&total=${total}&method=order";
            }else{
                alert("购物车为空！")
            }
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
    <div class="container "  >
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
<div id="myCarousel" class="carousel slide container" style="background-attachment: fixed ;background-position: center;height: 512px; overflow: hidden ;padding: 0; margin-top: 10px">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <c:forEach items="${foods_1s}" var="food_1" varStatus="s">
            <li data-target="#myCarousel" data-slide-to="${s.count}"></li>
        </c:forEach>

        <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img  src="http://p1.meituan.net/codeman/826a5ed09dab49af658c34624d75491861404.jpg" style="width: 100%"
                 alt="First slide">
        </div>
        <c:forEach items="${foods_1s}" var="food_1">
            <div class="item">
                <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/upload/food/${food_1.img}" style=" width: 100%"
                     alt="Second slide">
                </a>>
            </div>
        </c:forEach>


    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container" style="margin-top: 10px" >
    <div class="row" style="background:whitesmoke;padding: 10px;height:725px; border-radius: 6px" >
        <div class="col-xs-2 " style="height: 100%">
            <div class="list1 panel panel-default" style="margin-bottom: 0;height: 300px">
                <div class="panel-heading" style="text-align: center;">全部分类</div>
                <div class="panel-body" style="height:260px;overflow-y: scroll">

                    <ul class="nav nav-pills nav-stacked ">

                       <c:forEach items="${foodTypes}" var="foodType" >
                           <li><a href="${pageContext.request.contextPath}/indexServlet?foodTypeId=${foodType.id}&id=${dinnerTable.id}">${foodType.type_name}</a></li>
                       </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="list1 panel panel-default" style="margin-bottom: 0; height: 400px">
                <div class="panel-heading" style="height: 10%; text-align: center;">${dinnerTable.table_Name}的购物车</div>
                <div class="panel-body" style="height: 60%; overflow-y:scroll">
                    <ul style="margin: 0px;padding: 1em;list-style-type: none;border: 1px">
                        <c:if test="${empty foodList}">
                            <p style="text-align: center;color: red">购物车为空</p>
                        </c:if>

                        <c:if test="${not empty foodList}">
                            <c:forEach items="${foodList}" var="foodList" varStatus="s">
                                <li style="margin: 0px">
                                    <div>
                                        <a href="#">${foodList.food_name}</a>
                                        <input name="id" value="${foodList.id}"type="hidden">
                                        <%--(this,2,1,2)--%>
                                        <input name="buyNum" value="${foodList.buyNum}" onblur="blurFn(this,${foodList.id},${foodList.buyNum},${dinnerTable.id},${foodList.foodType_id})"
                                        style="width: 30px;border-radius: 3px;border: 1px solid #a3a3a3; text-align: right;padding: 2px 4px;">
                                        <%--(dinnerTableId foodId)--%>
                                        <input type="button" value="x" onclick="deleteFn(${dinnerTable.id},${foodList.id},${foodList.foodType_id});" style="border-radius: 3px;border:  1px solid #a3a3a3;background: bisque;">
                                    </div>

                                    <div style="float: right">
                                        <%--原价--%>
                                        <a><s>￥<fmt:formatNumber value="${foodList.price * foodList.buyNum}" pattern="0.00"/></s></a>
                                        <%--折扣价--%>
                                        <a><strong>￥<fmt:formatNumber value="${foodList.price * foodList.discount * foodList.buyNum}" pattern="0.00"/></strong></a>

                                    </div>
                                </li>
                            </c:forEach>
                        </c:if>
                    </ul>
                </div>
                <div class="panel-footer" style=" height: 30%;width: 100%;margin-top: 10px">
                    总金额：￥<fmt:formatNumber value="${total}" pattern="0.00"/><br>
                    <%--餐桌id   餐桌状态 1正在使用，0空闲--%>
                    <c:if test="${dinnerTable.table_status == 1}">
                        <input type="button" onclick="orderDinner(${dinnerTable.id},0)"value="取消占位" style="margin-top: 5px">
                        <%--dinnerTable--%>
                        <input type="button" onclick="order(${dinnerTable.id})"value="下单" style="margin-top: 5px; float: right">
                    </c:if>
                    <c:if test="${dinnerTable.table_status == 0}">
                        <input type="button" onclick="orderDinner(${dinnerTable.id},1)"value="占位" style="float: right">
                    </c:if>



                </div>
            </div>
        </div>
        <div class="col-xs-10" >
            <div class="panel panel-default">
                <div class="panel-heading" style="padding: 0">
                    <nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0">
                        <div class="container-fluid">
                            <div >
                                <ul class="nav navbar-nav">
                                    <li><a href="#">默认</a></li>
                                    <li><a href="#">价格</a></li>
                                    <li><a href="#">销量</a></li>
                                    <li><a href="#">好评最多</a></li>
                                </ul>
                            </div>

                            <form class="navbar-form navbar-right" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="搜索">
                                </div>
                                <button type="submit" class="btn btn-default">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </form>
                        </div>
                    </nav>
                </div>

                <div class="row" style="height: 648px;overflow-y: scroll">
                    <c:forEach items="${foods}" var="food" >
                        <div class="col-xs-6 col-md-3" style="height: 25%;width: 25%">
                            <div style="width: 100%;height: 100%">
                                <a href="#" class="thumbnail">
                                    <img src="${pageContext.request.contextPath}/upload/food/${food.img}" alt="${food.food_name}" height="100%" width="100%" />
                                </a>
                                <form action="" method="post">
                                    <input type="hidden" id="dinnerTableId" name="dinnerTableId" value="${dinnerTable.id}">
                                    <input type="hidden" id="foodTypeId" name="foodTypeId" value="${food.foodType_id}">

                                    <button type="button" onclick="addShopCar(${food.id})">
                                        加入购物车
                                    </button>
                                </form>


                            </div>

                            <div class="caption">
                                <h5>${food.food_name}</h5>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<h1 style="text-align: center">评论模块</h1>
<h1 style="text-align: center">......</h1>

<div class="container-fluid " style="height: 120px;background: #1C1C1C">
    <div class="row">
        <div class="col-xs-12">
            <h1>网页尾部</h1>
        </div>
    </div>
</div>
</body>
</html>