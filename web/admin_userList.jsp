<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/20
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <script>
        function deleteUser(id){
            //用户提示
            if(confirm("确定删除该行数据吗？")){
                //访问路径
                location.href = "${pageContext.request.contextPath}/userDelServlet?id="+id;
            }
        }
    </script>

</head>
<body>

<div class="" style="margin-top: 20px">

    <div style="float: right; margin: 5px">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_home.jsp">返回</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>登录名</th>
            <th>密码</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>用户创建时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${users}" var = "user" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${user.LOGIN_NAME}</td>
                <td>${user.PASSWORD}</td>
                <td>${user.PHONE}</td>
                <td>${user.EMAIL}</td>
                <td>${user.CREATE_DATE}</td>
                <c:if test="${user.DISABLED == 1}">
                    <td>已删除</td>
                </c:if>

                <c:if test="${user.DISABLED == 0}">
                    <td>存在</td>
                </c:if>

                <c:if test="${user.DISABLED == 0}">
                    <td><a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.ID});">删除用户</a></td>
                </c:if>

                <c:if test="${user.DISABLED == 1}">
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/userRevokeDelServlet?id=${user.ID}">撤销删除</a></td>
                </c:if>

            </tr>
        </c:forEach>

    </table>


</div>

</body>
</html>


