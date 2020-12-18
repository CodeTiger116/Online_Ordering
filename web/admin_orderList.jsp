<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/4
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>

<div class="">

    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/foodAddServlet">添加菜品</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>编号</th>

            <th style="width: 30%">订单编号</th>
            <th>桌号</th>
            <th>总价</th>
            <th>付款状态</th>
            <th>下单时间</th>
            <th>支付时间</th>
            <th>订单状态</th>

            <th>操作</th>

        </tr>

        <c:forEach items="${pb.list}" var = "order" varStatus="s">
            <tr>

                <td>${s.count + (pb.currentPage - 1) * 5}</td>
                <td>${order.order_code}</td>
                <td>${order.table_id}</td>
                <td>${order.total_Price}</td>
                <c:if test="${order.order_Status == 0}">
                    <td>未付款</td>
                </c:if>
                <c:if test="${order.order_Status == 1}">
                    <td>已付款</td>
                </c:if>

                <td>${order.order_Date}</td>
                <td>${order.pay_date}</td>

                <c:if test="${order.disabled == 0}">
                    <td>存在</td>
                </c:if>

                <td><a class="btn btn-default btn-sm" href="#">删除</a></td>

            </tr>
        </c:forEach>

    </table>

    <div class="container">

        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/orderFindByPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&rows=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/orderFindByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/orderFindByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>

                </c:forEach>

                <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/orderFindByPageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&rows=5" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 22px; margin-left: 5px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页。
                </span>
            </ul>
        </nav>
    </div>

</div>



</body>
</html>
