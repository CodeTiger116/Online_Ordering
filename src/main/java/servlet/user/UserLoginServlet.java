package servlet.user;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static sun.misc.Version.print;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        //获取用户输入的验证码
        String verifycode = request.getParameter("verifycode");


        //检验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            request.setAttribute("log_msg","验证码错误");
            //跳转登陆界面
            request.getRequestDispatcher("/index.jsp").forward(request,response);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();

        //封装user对象
        User user = new User();


        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //System.out.println(user.getLOGIN_NAME());
        //System.out.println(user.getPASSWORD());


        //调用service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);


        //判断是否登陆成功
        if(loginUser != null){
            //登陆成功
            session.setAttribute("user",loginUser);

            response.sendRedirect(request.getContextPath()+"/index_1Servlet");
        }else{
            //登陆失败
            request.setAttribute("login_msg","用户名或密码错误");

            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
