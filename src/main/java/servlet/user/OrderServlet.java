package servlet.user;

import bean.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //餐桌
        String dinnerTableId = request.getParameter("dinnerTableId");
        //购物车数据
        String method = request.getParameter("method");
        //总金额
        String total = request.getParameter("total");


        OrderService service = new OrderServiceImpl();

        //下单，将购物车中的信息保存在订单表
        HttpSession session = request.getSession();

        if(method != null && method.equals("order")){



            //根据餐桌id获取购物车
            Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(dinnerTableId);

            // != null 是判断Map是否为null（即是否new分配了内存空间，跟map中的键值对没有关系）
            // isEmpty()方法判断map是否有内容（即new分配内存空间，是否put了键值对，如果没有put就返回true，否则返回false）
            if(shopCar != null && !shopCar.isEmpty()){
                //保存到数据库
                service.order(dinnerTableId,shopCar,total);

                //下单之后删除购物车
                session.removeAttribute(dinnerTableId);

                //跳转到订单详情界面，查询餐桌未删除的订单
                //订单id  订单编号  下单时间   各个菜品及相应的购买数量和价格（原价、折扣价）   总价
                //涉及订单表、订单明细表、菜品表

                List<Order> orders = service.findByDinnerTableId(Integer.parseInt(dinnerTableId));


                request.setAttribute("orders",orders);


                //跳转到订单详情界面
                request.getRequestDispatcher("/orderItem.jsp").forward(request,response);

            }else{
                //购物车中没有商品，回到点餐页面
                response.sendRedirect(request.getContextPath()+"/indexServlet?id="+dinnerTableId);
            }

        }else if(method != null && method.equals("checkOrder")){

            //跳转到订单详情界面，查询餐桌未删除的订单
            //订单id  订单编号  下单时间   各个菜品及相应的购买数量和价格（原价、折扣价）   总价
            //涉及订单表、订单明细表、菜品表

            List<Order> orders = service.findByDinnerTableId(Integer.parseInt(dinnerTableId));


            request.setAttribute("orders",orders);


            //跳转到订单详情界面
            request.getRequestDispatcher("/orderItem.jsp").forward(request,response);
        }else if(method != null && method.equals("pay")){

            //订单id
            String orderId = request.getParameter("orderId");

            //付款,修改订单状态为已付款
            //付款状态，付款时间
            Order order = service.findById(orderId);
            order.setOrder_Status(1);
            order.setPay_date(new Date());

            //更新，方便复用
            service.update(order);

            //System.out.println(order);

            //付款成功，取消占位
            session.removeAttribute("dinnerTable");

            //返回
            response.sendRedirect(request.getContextPath()+"/index_1Servlet");

        }
    }


}
