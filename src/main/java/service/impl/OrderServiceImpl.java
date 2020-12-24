package service.impl;

import bean.Order;
import bean.OrderDetail;
import bean.PageBean;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    @Override
    public void order(String dinnerTableId, Map<Integer, Integer> shopCar ,String total) {

        Order order = new Order();


        StringBuffer orderCode =new StringBuffer();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");

        orderCode.append("HH-");
        orderCode.append(dateFormat.format(new Date()));

        orderCode.append(UUID.randomUUID().toString());

        order.setOrder_code(orderCode.toString());
        order.setTable_id(Integer.parseInt(dinnerTableId));
        order.setTotal_Price(Double.valueOf(total));

        //保存订单
        dao.order(order,Integer.parseInt(dinnerTableId),shopCar);
    }

    @Override
    public PageBean<Order> findOrderByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建空的PageBean对象
        PageBean<Order> pb = new PageBean<Order>();

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        int start = (currentPage - 1) * rows;

        //调用dao查询list集合
        List<Order> list = dao.findByPage(start,rows);

        //计算总页码
        int totalPage = totalCount % rows  == 0 ? (totalCount / rows) : (totalCount / rows + 1);


        //设置
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public List<Order> findByDinnerTableId(int tableId) {
        
        //根据餐桌id查询未删除的未付款的订单
        List<Order> orders = dao.findByDinnerTableId(tableId);

        //System.out.println("----------"+orders);

        //遍历所有的订单，根据订单id查询订单明细
        if(orders != null && orders.size() > 0){
            for(Order order : orders){

                List<OrderDetail>  details = dao.findByOrderId(order.getId());

                //System.out.println("------"+details);

                if(details != null && details.size() > 0){
                    order.setOrderDetails(details);
                }
            }
        }


        return orders;
    }

    @Override
    public Order findById(String orderId) {
        return dao.findById(Integer.parseInt(orderId));
    }

    @Override
    public void update(Order order) {
        dao.update(order);
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {

        return dao.findByOrderId(Integer.parseInt(orderId));
    }
}
