package servlet.manager;

import bean.DinnerTable;
import service.DinnerTableService;
import service.impl.DinnerTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 无用
 */

@WebServlet("/dinnerTableListServlet")
public class DinnerTableListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DinnerTableService service = new DinnerTableServiceImpl();
        List<DinnerTable> dinnerTables =  service.FindAll();
        //System.out.println(dinnerTables);


        request.setAttribute("dinnerTables",dinnerTables);

        request.getRequestDispatcher("/admin_dinnerTableList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
