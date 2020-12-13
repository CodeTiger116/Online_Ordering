package servlet.user;

import bean.DinnerTable;
import bean.Food;
import bean.FoodType;
import service.DinnerTableService;
import service.FoodService;
import service.FoodTypeService;
import service.impl.DinnerTableServiceImpl;
import service.impl.FoodServiceImpl;
import service.impl.FoodTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String foodTypeId = request.getParameter("foodTypeId");
        //获取餐桌的id
        String id = request.getParameter("id");
        //System.out.println(id);



        //查询菜品类型
        FoodTypeService service1 = new FoodTypeServiceImpl();
        List<FoodType> foodTypes =  service1.findFoodType();

        //System.out.println(foodTypes);
        request.setAttribute("foodTypes",foodTypes);


        if(foodTypeId == null || foodTypeId.equals("")){
            //默认查询第一个未删除的菜系的菜品（新品上市）
            Integer foodTypeIdInt = foodTypes.get(0).getId();
            foodTypeId = Integer.toString(foodTypeIdInt);
        }


        FoodService foodService = new FoodServiceImpl();
        //通过菜品类型id查询菜品
        List<Food> foods = foodService.findByTypeId(Integer.parseInt(foodTypeId));
        List<Food> foods_1s = foodService.findByTypeId(1);


        request.setAttribute("foods_1s",foods_1s);
        request.setAttribute("foods",foods);
        //System.out.println(foods);
        //System.out.println(foods_1s);


        //通过餐桌的id查询餐桌
        DinnerTableService service = new DinnerTableServiceImpl();
        DinnerTable dinnerTable = service.findByTableId(id);
        request.setAttribute("dinnerTable",dinnerTable);

        //购物车展示
        HttpSession session = request.getSession();
        Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(id);

        List<Food> foodList = new ArrayList<>();

        //总价
        Double total = 0.00;

        if(shopCar != null){
            Set<Integer> foodIds = shopCar.keySet();
            for(Integer foodId : foodIds){
                //通过菜品的id查询菜品
                Food food = foodService.findByFoodId(foodId);
                //System.out.println(food);

                //通过key获取value,即购买数量
                Integer buyNum = shopCar.get(foodId);
                food.setBuyNum(buyNum);
                foodList.add(food);


                //当前商品价格
                Double price = food.getPrice() * food.getDiscount() * food.getBuyNum();
                total += price;
            }
        }

        //总价
        request.setAttribute("total",total);

        request.setAttribute("foodList",foodList);
        //System.out.println(foodList);

        request.getRequestDispatcher("/home.jsp").forward(request,response);



    }


}
