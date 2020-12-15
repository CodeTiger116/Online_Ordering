package servlet.user;

import bean.DinnerTable;
import bean.User;
import service.DinnerTableService;
import service.impl.DinnerTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index_1Servlet")
public class Index_1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //查询未使用的餐桌
        //根据使用状态  0未使用
        DinnerTableService service = new DinnerTableServiceImpl();
        int tableStatus = 0;
        List<DinnerTable> dinnerTables = service.findDinnerTables(tableStatus);

        request.setAttribute("dinnerTables",dinnerTables);


        //查询正在使用的餐桌
        int tableStatus_1 = 1;
        List<DinnerTable> dinnerTables_1 = service.findDinnerTables(tableStatus_1);

        request.setAttribute("dinnerTables_1",dinnerTables_1);

        //System.out.println(dinnerTables_1);



        request.getRequestDispatcher("/home_1.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
