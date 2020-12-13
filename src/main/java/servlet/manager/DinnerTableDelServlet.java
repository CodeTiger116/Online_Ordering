package servlet.manager;

import service.DinnerTableService;
import service.UserService;
import service.impl.DinnerTableServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dinnerTableDelServlet")
public class DinnerTableDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取id
        String id = request.getParameter("id");

        //2.调用service删除
        DinnerTableService service = new DinnerTableServiceImpl();
        service.deleteDinnerTable(id);

        //3.跳转
        response.sendRedirect(request.getContextPath()+ "/dinnerTableFindByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
