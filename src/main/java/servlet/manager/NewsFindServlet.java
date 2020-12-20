package servlet.manager;

import bean.News;
import bean.User;
import service.NewsService;
import service.UserService;
import service.impl.NewsServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newsFindServlet")
public class NewsFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");


        NewsService service = new NewsServiceImpl();
        List<News> news = service.FindAll();

        request.setAttribute("news",news);

        if(method != null && method.equals("adminfind")){


            //System.out.println(news);

            request.setAttribute("mainRight","admin_newsList.jsp");
            request.getRequestDispatcher("/admin_home.jsp").forward(request,response);
        }
        else if(method != null && method.equals("homefind")){
            request.getRequestDispatcher("/user_news.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
