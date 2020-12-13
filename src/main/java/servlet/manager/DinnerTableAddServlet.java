package servlet.manager;

import bean.DinnerTable;
import org.apache.commons.beanutils.BeanUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/dinnerTableAddServlet")
public class DinnerTableAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        DinnerTable dinnerTable = new DinnerTable();

        try {
            BeanUtils.populate(dinnerTable,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        

        //调用service保存
        DinnerTableService service = new DinnerTableServiceImpl();
        service.addDinnerTable(dinnerTable);

        //跳转到UserListServlet
        response.sendRedirect(request.getContextPath()+"/dinnerTableFindByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
