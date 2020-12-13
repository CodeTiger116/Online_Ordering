package servlet.user;

import bean.DinnerTable;
import service.DinnerTableService;
import service.impl.DinnerTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/dinnerTableStatusServlet")
public class DinnerTableStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String dinnerTableId = request.getParameter("dinnerTableId");
        String tableStatus = request.getParameter("tableStatus");

        //根据id查询餐桌（方法已经存在）
        DinnerTableService service = new DinnerTableServiceImpl();
        DinnerTable dinnerTable = service.findByTableId(dinnerTableId);

        //
        dinnerTable.setTable_status(Integer.parseInt(tableStatus));
        dinnerTable.setBegin_use_date(new Date());

        //更改数据库(写通用，方便复用)
        service.updateDinnerTable(dinnerTable);

        response.sendRedirect(request.getContextPath()+"/indexServlet?id="+dinnerTableId);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
