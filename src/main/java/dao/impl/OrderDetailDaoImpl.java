package dao.impl;

import dao.OrderDetailDao;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class OrderDetailDaoImpl implements OrderDetailDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
}
