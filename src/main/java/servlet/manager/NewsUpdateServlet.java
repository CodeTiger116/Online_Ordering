package servlet.manager;

import bean.News;
import org.apache.commons.beanutils.BeanUtils;
import service.NewsService;
import service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/newsUpdateServlet")
public class NewsUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();

        News news = new News();

        try {
            BeanUtils.populate(news,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        NewsService service = new NewsServiceImpl();
        service.UpdateNews(news);

        response.sendRedirect(request.getContextPath()+"/newsFindServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
