package servlet.user;

import bean.ResultInfo;
import bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
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
        System.out.println(checkcode_server);

        if(!checkcode_server.equalsIgnoreCase(verifycode)){

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误!");

            // 将resultInfo序列化为json字符串
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);

            // 将json数据回写给客户端浏览器
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);

            return;

        }


        // 1.获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();


        System.out.println("map:"+parameterMap);
        // 2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        // 3.调用service完成注册
        boolean flag = service.register(user);
        ResultInfo resultInfo = new ResultInfo();

        System.out.println("flag:"+ flag);
        // 4.响应结果
        if (flag) {     // 注册成功
            resultInfo.setFlag(true);
        } else {        // 注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");
        }

        // 将resultInfo序列化为json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        // 将json数据回写给客户端浏览器
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
