package dao;

import bean.Order;
import bean.OrderDetail;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderDao {
    /**
     * 保存订单
     * @param parseInt
     * @param shopCar
     */
    void order(Order order, int parseInt, Map<Integer, Integer> shopCar);

    /**
     *
     * @return
     */
    int findTotalCount();

    /**
     *
     * @param start
     * @param rows
     * @return
     */
    List<Order> findByPage(int start, int rows);

    /**
     *
     * @param tableId
     * @return
     */
    List<Order> findByDinnerTableId(int tableId);

    /**
     * 根据订单id查询订单明细，
     * @param id
     * @return
     */
    List<OrderDetail> findByOrderId(int id);

    /**
     * 根据订单id查询
     * @param parseInt
     * @return
     */
    Order findById(int parseInt);

    /**
     * 修改订单
     * @param order
     */
    void update(Order order);
}
