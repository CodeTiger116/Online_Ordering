package servlet.manager;

import bean.Food;
import bean.News;
import service.NewsService;
import service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsFindByIdServlet")
public class NewsFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        NewsService service = new NewsServiceImpl();
        News news =  service.findByNewsId(Integer.parseInt(id));

        request.setAttribute("news",news);
        request.getRequestDispatcher("/admin_news_update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
