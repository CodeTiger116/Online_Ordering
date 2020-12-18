<%--  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/22
  Time: 16:49
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜品管理</title>
<%--    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>--%>
</head>
<body>

<div >

    <div style="float: left; margin-top: 15px">
        <form class="form-inline" action="${pageContext.request.contextPath}/foodFindByPageServlet" method="post">
            <div class="form-group">
                <label for="food_name">名称:</label>
                <input id = "food_name" name="food_name" type="text" class="form-control" value="${condition.name[0]}" >
            </div>
            <div class="form-group">
                <label for="food_type">类型:</label>

                    <select id="food_type" name="foodType_id" class="form-control" >
                        <option value="" selected>全部</option>
                        <option value="1">新品上市</option>
                        <option value="2">超值套餐</option>
                        <option value="3">主食</option>
                        <option value="4">甜点/饮料</option>
                        <option value="5">小食</option>
                    </select>


            </div>
            <div class="form-group">
                <label for="disabled">状态:</label>
                <select id="disabled" name="disabled" class="form-control" >
                    <option value="" selected>全部</option>
                    <option value="0">未删除</option>
                    <option value="1">已删除</option>

                </select>
            </div>

            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_foodAdd.jsp">添加菜品</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover"
           style=" width: 100%;
           table-layout: fixed;
           text-overflow: ellipsis;
           -moz-text-overflow: ellipsis;
           overflow: hidden;
           white-space: nowrap;
           text-align: left ">

        <tr class="success">

            <th>编号</th>
            <th>名称</th>
            <th>菜品类型</th>
            <th>价格</th>
            <th>折扣 </th>
            <th style="width: 30%; overflow: hidden;white-space: nowrap;-moz-text-overflow: ellipsis;">描述 </th>
            <th>图片 </th>
            <th>创建时间 </th>
            <th>更新时间 </th>
            <th>状态</th>
            <th>操作</th>

        </tr>

        <c:forEach items="${pb.list}" var = "food" varStatus="s">
            <tr>

                <td>${s.count + (pb.currentPage - 1) * 5}</td>
                <td>${food.food_name}</td>
                <td>${food.foodType_id}</td>
                <td>${food.price}</td>
                <td>${food.discount}</td>
                <td style="overflow: hidden;white-space: normal;-moz-text-overflow: ellipsis;">${food.remark}</td>
                <td>${food.img}</td>
                <td>${food.create_date}</td>
                <td>${food.update_date}</td>
                <td>${food.disabled}</td>

                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/foodFindByIdServlet?id=${food.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/foodDeleteServlet?id=${food.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
</div>

    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li>
                </c:if>

                    <a href="${pageContext.request.contextPath}/foodFindByPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&rows=5&food_name=${condition.food_name[0]}&food_TypeId=${condition.food_TypeId[0]}&disabled=${condition.disabled[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/foodFindByPageServlet?currentPage=${i}&rows=5&food_name=${condition.food_name[0]}&food_TypeId=${condition.food_TypeId[0]}&disabled=${condition.disabled[0]}">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/foodFindByPageServlet?currentPage=${i}&rows=5&food_name=${condition.food_name[0]}&food_TypeId=${condition.food_TypeId[0]}&disabled=${condition.disabled[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>

                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/foodFindByPageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&rows=5&food_name=${condition.name[0]}&food_TypeId=${condition.food_TypeId[0]}&disabled=${condition.disabled[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 22px; margin-left: 5px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页。
                </span>
            </ul>
        </nav>

    </div>

</body>
</html>
