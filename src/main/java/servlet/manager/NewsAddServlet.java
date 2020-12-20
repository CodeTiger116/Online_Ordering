package servlet.manager;

import bean.News;
import org.apache.commons.beanutils.BeanUtils;
import service.DinnerTableService;
import service.NewsService;
import service.impl.DinnerTableServiceImpl;
import service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/newsAddServlet")
public class NewsAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();

        //封装对象
        News news = new News();

        try {
            BeanUtils.populate(news,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service保存
        NewsService service = new NewsServiceImpl();
        service.addNews(news);


        response.sendRedirect(request.getContextPath()+"/newsFindServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
