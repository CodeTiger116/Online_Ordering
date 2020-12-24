package service;

import bean.Order;
import bean.OrderDetail;
import bean.PageBean;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 下单，将数据存到订单表
     * @param dinnerTableId
     * @param shopCar
     */
    void order(String dinnerTableId, Map<Integer, Integer> shopCar,String total);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<Order> findOrderByPage(String currentPage, String rows);

    /**
     * 根据餐桌id查询订单
     * @param parseInt
     * @return
     */
    List<Order> findByDinnerTableId(int parseInt);

    /**
     * 根据订单id查找订单
     * @param orderId
     * @return
     */
    Order findById(String orderId);

    /**
     * 修改订单
     * @param order
     */
    void update(Order order);

    /**
     * 根据id查询订单明细
     * @return
     * @param orderId
     */
    List<OrderDetail> findByOrderId(String orderId);
}
