<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改菜品</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


    <script type="text/javascript">

        function addSubmitTest(){
            //获取上传文件的本地路径
            const imagName = $("#img").val();
            //找到最后.的索引值
            const extStar = imagName.lastIndexOf(".");
            //获取.jpg  改为小写
            const ext = imagName.substring(extStar, imagName.length);
            //alert(ext);
            if(imagName == null || imagName == ""){
                $("#message").html("请上传菜品图片");
                return false;
            }else if(ext.match(/.png|.jpg|.gif|.jpeg|.bmp/) == null){
                $("#message").html("图片格式不正确");
                return false;
            }
            document.getElementById("form").submit();
        }

    </script>


</head>
<body>


<div class="container" style="width: 500px;">
    <h3 style="text-align: center;">添加菜品</h3>

    <div id="message" style="color: red; text-align: center"></div>
    <form id="form" action="${pageContext.request.contextPath}/foodAddServlet" enctype="multipart/form-data" method="post">

        <!--隐藏域，提交id-->
        <input type="hidden" name = "id" value="${user.id}">

        <div class="form-group">
            <label for="food_name">菜名：</label>
            <input type="text" class="form-control" id="food_name" name="food_name" value="${user.name}"  placeholder="请输入名称" />
        </div>



        <div class="form-group">
            <label for="food_type">菜品类型：</label>
            <select id="food_type" name="foodType_id" class="form-control" >
                <option value=1>新品上市</option>
                <option value=2>超值套餐</option>
                <option value="3">主食</option>
                <option value="4">甜点/饮料</option>
                <option value="5">小食</option>
            </select>
        </div>

        <div class="form-group">
            <label for="price">价格：</label>
            <input type="text" class="form-control" id="price" name="price" value="${user.qq}" placeholder="请输入价格"/>
        </div>

        <div class="form-group">
            <label for="discount">折扣：</label>
            <input type="text" class="form-control" id="discount" name="discount" value="${user.email}" placeholder="请输入折扣"/>
        </div>

        <div class="form-group">
            <label for="remark">描述：</label>
            <%--<input type="text"  class="form-control" id="remark" name="remark" value="${user.email}" placeholder="请输入描述"/>--%>
            <textarea class="form-control" id="remark" name="remark" cols="5" rows="5" >默认值</textarea>
        </div>

        <div class="form-group">
            <label >图片：</label>
                上传文件：<input id="img" name="img"  type="file"  /><br>
                <input type="reset" value="重置" />

        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" onblur="addSubmitTest()" type="button" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>

</html>

