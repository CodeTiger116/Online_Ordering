package servlet.manager;

import bean.DinnerTable;
import bean.User;
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
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        UserService service = new UserServiceImpl();
        List<User> users = service.FindAll();

        //System.out.println(users);

        request.setAttribute("users",users);
        //request.getRequestDispatcher("/admin_userList.jsp").forward(request,response);

        request.setAttribute("mainRight","admin_userList.jsp");
        request.getRequestDispatcher("/admin_home.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
