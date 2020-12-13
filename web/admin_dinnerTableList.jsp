<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/22
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>餐桌管理</title>


<%--    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>--%>

    <script>
        function deleteDinnerTable(id){
            //用户提示
            if(confirm("确定撤销该餐桌吗？")){
                //访问路径
                location.href = "${pageContext.request.contextPath}/dinnerTableDelServlet?id="+id;
            }
        }
    </script>

</head>
<body>

<%--<jsp:include page="admin_home.jsp"/>--%>
<div class="container">

    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_dinnerTableAdd.jsp">添加餐桌</a></td>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_home.jsp">返回</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type = "checkbox"></th>
            <th>编号</th>
            <th>餐桌名称</th>
            <th>使用状态</th>
            <th>餐桌开始占用</th>
            <th>餐桌创建时间</th>
            <th>餐桌信息修改时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var = "dinnertable" varStatus="s">
            <tr>
                <th><input type = "checkbox"></th>
                <td>${s.count}</td>
                <td>${dinnertable.table_Name}</td>
                <td>${dinnertable.table_status}</td>
                <td>${dinnertable.begin_use_date}</td>
                <td>${dinnertable.create_date}</td>
                <td>${dinnertable.update_date}</td>
                <%--<td>${dinnertable.disabled}</td>--%>
                <c:if test="${dinnertable.disabled == 1}">
                    <td>已撤销</td>
                </c:if>

                <c:if test="${dinnertable.disabled == 0}">
                    <td>正在使用</td>
                </c:if>


                <c:if test="${dinnertable.disabled == 0}">
                    <td><a class="btn btn-default btn-sm" href="javascript:deleteDinnerTable(${dinnertable.id});">撤销</a></td>
                </c:if>

                <c:if test="${dinnertable.disabled == 1}">
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/dinnerTableRevokeDelServlet?id=${dinnertable.id}">启用</a></td>
                </c:if>
            </tr>
        </c:forEach>

    </table>


    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/dinnerTableFindByPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&rows=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/dinnerTableFindByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/dinnerTableFindByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>

                </c:forEach>

                <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/dinnerTableFindByPageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&rows=5" aria-label="Next">
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
