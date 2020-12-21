package servlet.user;

import bean.Food;
import service.FoodService;
import service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/foodPriceSortServlet")
public class FoodPriceSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("dinnerTableId");
        String foodTypeId = request.getParameter("foodTypeId");


        //排序
        FoodService service = new FoodServiceImpl();
       // List<Food> foods = service.priceSort(foodTypeId);


        //request.setAttribute("foods_1s",foods);
       // request.setAttribute("foods",foods);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
