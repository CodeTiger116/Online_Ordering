package servlet.admin;

import bean.Manager;
import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        request.setCharacterEncoding("utf-8");

        //
        Map<String, String[]> map = request.getParameterMap();
        Manager manager = new Manager();

        try {
            BeanUtils.populate(manager,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        AdminService service = new AdminServiceImpl();
        Manager loginManager = service.login(manager);

        HttpSession session = request.getSession();

        if(loginManager != null){
            //登陆成功
            session.setAttribute("admin",loginManager);
            response.sendRedirect(request.getContextPath()+"/admin_home.jsp");
        }else{
            //登陆失败
            request.setAttribute("admin_login_msg","用户名或密码错误");

            request.getRequestDispatcher("/admin_login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
