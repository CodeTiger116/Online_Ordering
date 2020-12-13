package servlet.manager;

import bean.Food;
import bean.PageBean;
import service.FoodService;
import service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/foodFindByPageServlet")
public class FoodFindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String currentPage = request.getParameter("currentPage");  //当前页码
        String rows = request.getParameter("rows");  //每页显示的条数


        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5";
        }



        //调用service查询

        FoodService service = new FoodServiceImpl();
        PageBean<Food> pb = service.findUserByPage(currentPage,rows);
        //System.out.println(pb);

        //将PageBean存入request
        request.setAttribute("pb",pb);

        //转发
        //request.getRequestDispatcher("/admin_foodList.jsp").forward(request,response);
        request.setAttribute("mainRight","/admin_foodList.jsp");
        request.getRequestDispatcher("admin_home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
