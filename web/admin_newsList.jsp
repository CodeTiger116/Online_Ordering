<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/20
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>公告</title>


    <script>
        function deleteNews(id){
            //用户提示
            if(confirm("确定删除该条公告吗？")){
                //访问路径
                location.href = "${pageContext.request.contextPath}/newsDelServlet?id="+id;
            }
        }

    </script>
</head>
<body>
<div class="" style="margin-top: 20px">

    <div style="float: left; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_home.jsp">返回</a></td>
    </div>

    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin_news_add.jsp">发布公告</a></td>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>标题</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>修改时间</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${news}" var = "neww" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${neww.title}</td>
                <td>${neww.content}</td>
                <td>${neww.push_date}</td>
                <td>${neww.update_date}</td>
                <td><a class="btn btn-default btn-sm" href="javascript:deleteNews(${neww.id});">删除</a>
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/newsFindByIdServlet?id=${neww.id}">修改</a></td>


            </tr>
        </c:forEach>

    </table>


</div>

</body>
</html>



