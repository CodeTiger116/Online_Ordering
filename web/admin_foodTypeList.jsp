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

    <script type="text/javascript">

        function deleteFoodType(){
            if(confirm("确定删除该条内容？")){
                //访问路径
                //location.href = "${pageContext.request.contextPath}/;
            }
        }

        function add(){
            //window.open("admin_foodTypeAdd.jsp");

            prompt("请输入想要添加的菜品类型名称","新品上市");

        }

    </script>

</head>
<body>
<div class="" style="margin-top: 20px">

    <div style="float: right; margin:5px">
         <a class="btn btn-primary" onclick="add()">添加菜品类型</a></td>
    </div>

    <div style="float: left; margin:5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_home.jsp">返回</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th >编号</th>
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

                <c:if test="${foodType.disabled == 0}">
                    <td>未删除</td>
                </c:if>

                <c:if test="${foodType.disabled == 1}">
                    <td>未删除</td>
                </c:if>



                <td ><a  class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/admin_foodTypeUpdate.jsp">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" onclick="deleteFoodType()">删除</a></td>
            </tr>
        </c:forEach>

    </table>



</div>


</body>
</html>
