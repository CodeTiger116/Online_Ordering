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
        String newsId = request.getParameter("newsId");

        //System.out.println(newsId);


        NewsService service = new NewsServiceImpl();
        List<News> news = service.FindAll();

        request.setAttribute("news",news);

        if(method != null && method.equals("adminfind")){


            //System.out.println(news);

            request.setAttribute("mainRight","admin_newsList.jsp");
            request.getRequestDispatcher("/admin_home.jsp").forward(request,response);
        }
        else if(method != null && method.equals("homefind")){

            News newsDetail = new News();

            if(newsId == null || newsId.equals("") ){
                //查询默认第一条
                Integer newsIdInt = news.get(0).getId();
                newsDetail = service.findByNewsId(newsIdInt);

                //System.out.println(newsDetail);

            }else {
                newsDetail = service.findByNewsId(Integer.parseInt(newsId));
            }

            request.setAttribute("newsDetail" ,newsDetail);
            request.getRequestDispatcher("/newsItem.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
