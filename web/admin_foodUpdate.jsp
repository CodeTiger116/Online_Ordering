<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/23
  Time: 12:43
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
        function ajaxFoodName(){
            //通过id选择器获取输入的菜品名字
            var foodName = $("#food_name").val();
            if(foodName == null || foodName == ""){
                $("#message").html("菜品名字不能为空");

            }else{
                //查询用户输入的菜品名是否已经存在
            }

        }
    </script>


</head>
<body>


<div class="container" style="width: 500px;">
    <h3 style="text-align: center;">修改菜品</h3>
    <form action="${pageContext.request.contextPath}/foodUpdateServlet" enctype="multipart/form-data" method="post">

        <!--隐藏域，提交id-->
        <input type="hidden" name = "id" value="${food.id}">

        <div class="form-group">
            <label for="food_name">菜名：</label>
            <input type="text" class="form-control" id="food_name" name="food_name" value="${food.food_name}"  placeholder="请输入名称" />

            <label color="red" id="message" ></label>
        </div>



        <div class="form-group">
            <label for="food_type">菜品类型：</label>
            <select id="food_type" name="foodType_id" class="form-control" >
                <c:if test="${food.foodType_id == 1}">
                    <option value="1" selected>新品上市</option>
                    <option value="2">超值套餐</option>
                    <option value="3">主食</option>
                    <option value="4">甜点/饮料</option>
                    <option value="5">小食</option>
                </c:if>

                <c:if test="${food.foodType_id == 2}">
                    <option value="1" >新品上市</option>
                    <option value="2" selected>超值套餐</option>
                    <option value="3">主食</option>
                    <option value="4">甜点/饮料</option>
                    <option value="5">小食</option>
                </c:if>

                <c:if test="${food.foodType_id == 3}">
                    <option value="1">新品上市</option>
                    <option value="2">超值套餐</option>
                    <option value="3" selected>主食</option>
                    <option value="4">甜点/饮料</option>
                    <option value="5">小食</option>
                </c:if>

                <c:if test="${food.foodType_id == 4}">
                    <option value="1">新品上市</option>
                    <option value="2">超值套餐</option>
                    <option value="3">主食</option>
                    <option value="4" selected>甜点/饮料</option>
                    <option value="5">小食</option>
                </c:if>

                <c:if test="${food.foodType_id == 5}">
                    <option value="1">新品上市</option>
                    <option value="2">超值套餐</option>
                    <option value="3">主食</option>
                    <option value="4">甜点/饮料</option>
                    <option value="5" selected>小食</option>
                </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="price">价格：</label>
            <input type="text" class="form-control" id="price" name="price" value="${food.price}" placeholder="请输入价格"/>
        </div>

        <div class="form-group">
            <label for="discount">折扣：</label>
            <input type="text" class="form-control" id="discount" name="discount" value="${food.discount}" placeholder="请输入折扣"/>
        </div>

        <div class="form-group">
            <label for="remark">描述：</label>
            <textarea class="form-control" id="remark" name="remark" cols="5" rows="5" >${food.remark}</textarea>
        </div>

        <div class="form-group">
            <label for="img">图片：</label>
            <c:if test="${food.img == null}">
                <a style="color: red">没有图片文件，请上传图片：</a><input id="img" name="img"  type="file"  /><br>
                <input type="reset" value="重置" />
            </c:if>

            <c:if test="${food.img != null}">
                <div class="row">
                    <div class="col-xs-6 col-md-3">
                        <a class="thumbnail">
                            <img src="${pageContext.request.contextPath}/upload/food/${food.img}">
                        </a>

                    </div>

                </div>
                修改图片：<input id="img" name="img"  type="file" value="${food.img}" /><br>
                <input type="reset" value="重置" />
            </c:if>

        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>

</html>

