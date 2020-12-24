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

@WebServlet("/findFoodDetailServlet")
public class FindFoodDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String dinnerTableId = request.getParameter("dinnerTableId");

        FoodService foodService = new FoodServiceImpl();
        Food food = foodService.findByFoodId(Integer.parseInt(id));

        request.setAttribute("food",food);
        request.setAttribute("dinnerTableId",dinnerTableId);
        request.getRequestDispatcher("/foodDetail.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
