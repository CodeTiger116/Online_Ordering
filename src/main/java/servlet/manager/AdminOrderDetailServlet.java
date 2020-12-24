package servlet.manager;

import bean.Order;
import bean.OrderDetail;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminOrderDetailServlet")
public class AdminOrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String orderId = request.getParameter("orderId");

        OrderService service = new OrderServiceImpl();


        List<OrderDetail> orders = service.findByOrderId(orderId);
        Order order = service.findById(orderId);

        System.out.println(orders);
        request.setAttribute("orders",orders);
        request.setAttribute("order",order);

        request.setAttribute("mainRight","/admin_orderDetail.jsp");
        request.getRequestDispatcher("admin_home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
