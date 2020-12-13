package dao.impl;

import bean.Manager;
import bean.User;
import dao.AdminDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Manager FindAdminUserByUserNameAndPassword(String username, String password) {

        try {
            String sql = "select * from tb_manager where username = ? and password = ?";
            Manager manager = template.queryForObject(sql,new BeanPropertyRowMapper<Manager>(Manager.class),username,password);
            return manager;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
