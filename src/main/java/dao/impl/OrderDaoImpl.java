package dao.impl;

import bean.DinnerTable;
import bean.Food;
import bean.Order;
import bean.OrderDetail;
import dao.FoodDao;
import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import service.DinnerTableService;
import service.impl.DinnerTableServiceImpl;
import utils.ConnectionUtils;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void order(Order order,int parseInt, Map<Integer, Integer> shopCar) {

       /* //设置手动提交事务
        try {
            template.getDataSource().getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/



        //在1对N的表关系中，要用1方表自增生成的主键作为N方表的外键，
        // 因此插入1方表insert方法的返回值为主键值，这样可以用返回值插入N方表
        String sql = "insert into tb_order(order_code,table_id,total_Price,order_date)values(?,?,?,now())";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1,order.getOrder_code());
                ps.setInt(2,order.getTable_id());
                ps.setDouble(3,order.getTotal_Price());

                return ps;
            }
        },keyHolder);



        Integer orderId = keyHolder.getKey().intValue();
        /*template.update(sql,order.getOrder_code(),order.getTable_id(),order.getTotal_Price());*/

        //System.out.println(orderId);


        //int i = 100/0;

        //保存订单明细
        //获取购物车中所有的菜品id
        Set<Integer> foodIds = shopCar.keySet();
        for(Integer foodId:foodIds){
            //购买数量
            Integer buyNum = shopCar.get(foodId);

            //购买时的折扣
            FoodDao foodDao = new FoodDaoImpl();
            Food food = foodDao.findByFoodId(foodId);


            String sqlItem = "insert into tb_order_detail(orderId,food_id,buyNum,discount) values(?,?,?,?)";
            template.update(sqlItem,orderId,foodId,buyNum,food.getDiscount());
        }

        /*//提交事务
        try {
            template.getDataSource().getConnection().commit();
            template.getDataSource().getConnection().setAutoCommit(true);//还原
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/


    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tb_order ";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Order> findByPage(int start, int rows) {
        String sql = "select * from tb_order limit ?, ?";

        return template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),start,rows);
    }

    @Override
    public List<Order> findByDinnerTableId(int tableId) {

        String sql = "select * from tb_order where disabled = 0 and table_id = ? and order_Status = 0";
        List<Order> orders = template.query(sql, new BeanPropertyRowMapper<Order>(Order.class), tableId);
        return orders;
    }


    @Override
    public List<OrderDetail> findByOrderId(int id) {

        /*String sql = "SELECT tb_order_detail.id detailId,tb_order_detail.*,tb_food.* FROM tb_order_detail LEFT JOIN tb_food ON tb_food.id = tb_order_detail.food_id WHERE orderId = ? AND tb_order_detail.disabled = 0";
        List<OrderDetail> orderDetails = template.query(sql, new BeanPropertyRowMapper<OrderDetail>(OrderDetail.class), id);

        Food food = new Food();*/

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;


        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "SELECT tb_order_detail.id detailId,tb_order_detail.*,tb_food.* FROM tb_order_detail LEFT JOIN tb_food ON tb_food.id = tb_order_detail.food_id WHERE orderId = ? AND tb_order_detail.disabled = 0";
            //获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setInt(1,id);
            resultSet = pstmt.executeQuery();

            List<OrderDetail> orderDetails = new ArrayList<>();
            while(resultSet.next()){

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setBuyNum(resultSet.getInt("buyNum"));
                orderDetail.setOrderId(resultSet.getInt("orderId"));
                orderDetail.setFood_id(resultSet.getInt("food_id"));
                orderDetail.setDiscount(resultSet.getDouble("discount"));

                Food food = new Food();
                food.setFoodType_id(resultSet.getInt("foodType_id"));
                food.setFood_name(resultSet.getString("food_name"));
                food.setImg(resultSet.getString("img"));
                food.setDiscount(resultSet.getDouble("discount"));
                food.setPrice(resultSet.getDouble("price"));
                food.setRemark(resultSet.getString("remark"));

                orderDetail.setFood(food);
                orderDetails.add(orderDetail);
            }
            return orderDetails;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            JDBCUtils.close(resultSet,pstmt,conn);
        }

        return null;
    }

    @Override
    public Order findById(int orderId) {
        String sql = "select * from tb_order where id = ?";
        Order order = template.queryForObject(sql, new BeanPropertyRowMapper<Order>(Order.class), orderId);
        return order;
    }

    @Override
    public void update(Order order) {
        String sql = "update tb_order set order_code = ? ,table_id = ?,total_Price = ?,order_Status = ? ,order_Date = ? ,pay_date = ?,disabled = ? where id = ?";
        template.update(sql,order.getOrder_code(),order.getTable_id(),order.getTotal_Price(),order.getOrder_Status(),order.getOrder_Date(),order.getPay_date(),order.getDisabled(),order.getId());

        //取消占位
        //根据id查询餐桌（方法已经存在）
        DinnerTableService dinnerTableService = new DinnerTableServiceImpl();
        DinnerTable dinnerTable = dinnerTableService.findByTableId(Integer.toString(order.getTable_id()));
        //0未使用
        dinnerTable.setTable_status(0);
        dinnerTable.setUpdate_date(new Date());
        //更改数据库(写通用，方便复用)
        dinnerTableService.updateDinnerTable(dinnerTable);
    }
}
