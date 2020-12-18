<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


<%--    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>--%>
</head>
<body>
<div class="">

    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_home.jsp">返回</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>编号</th>
            <th>名称</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>状态 </th>
            <th>操作</th>

        </tr>

        <c:forEach items="${foodTypes}" var = "foodType" varStatus="s">
            <tr>

                <td>${s.count}</td>
                <td>${foodType.type_name}</td>
                <td>${foodType.create_date}</td>
                <td>${foodType.update_date}</td>
                <td>${foodType.disabled}</td>

                <td ><a  class="btn btn-default btn-sm" href="">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="">删除</a></td>
            </tr>
        </c:forEach>

    </table>



</div>


</body>
</html>
