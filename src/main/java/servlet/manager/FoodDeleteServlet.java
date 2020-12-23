package servlet.manager;

import bean.Food;
import service.DinnerTableService;
import service.FoodService;
import service.impl.DinnerTableServiceImpl;
import service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/foodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取id
        String id = request.getParameter("id");

        String method = request.getParameter("method");


        FoodService service = new FoodServiceImpl();

        if(method != null && method.equals("del")){
            //2.调用service删除
            service.deleteFood(id,1);
        }else if(method != null && method.equals("revoke")){
            service.deleteFood(id,0);
        }



        //3.跳转
        response.sendRedirect(request.getContextPath()+ "/foodFindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
