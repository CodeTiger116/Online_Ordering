<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/17
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>个人中心</title>

</head>
<body>




${user.ID}<br>
我的用户名：${user.LOGIN_NAME}<br>
我的密码：${user.PASSWORD}<br>
我的邮箱：${user.EMAIL}<br>
我的电话：${user.PHONE}


<div class="container">
    <div style="float: left; margin: 5px">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/updateUserServlet?ID=${user.ID}">修改信息</a>

    </div>
</div>


</body>
</html>
