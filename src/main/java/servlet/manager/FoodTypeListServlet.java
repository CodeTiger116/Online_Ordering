package servlet.manager;

import bean.FoodType;
import service.FoodTypeService;
import service.impl.FoodTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/foodTypeListServlet")
public class FoodTypeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodTypeService service = new FoodTypeServiceImpl();
        List<FoodType> foodTypes = service.FindAll();
        //System.out.println(foodTypes);

        request.setAttribute("foodTypes",foodTypes);


        //request.getRequestDispatcher("/admin_foodTypeList.jsp").forward(request,response);
        request.setAttribute("mainRight","admin_foodTypeList.jsp");
        request.getRequestDispatcher("admin_home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
