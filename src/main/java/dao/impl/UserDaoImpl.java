package dao.impl;

import bean.User;
import dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByUsernameAndPassword(String login_name, String password) {
        try {
            String sql = "select * from tb_user where LOGIN_NAME = ? and PASSWORD = ? and DISABLED = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_name, password, 0);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public User FindById(int id) {
        String sql = "select * from tb_user where ID = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }


    @Override
    public List<User> findAll() {

        String sql = "select * from tb_user";

        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }


    @Override
    public void delete(int id) {

        String sql = "update tb_user set DISABLED = 1 where ID = ?";
        template.update(sql, id);
    }

    @Override
    public void revokeDelUser(int id) {
        String sql = "update tb_user set DISABLED = 0 where ID = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserByUserName(String login_name) {


        User user = null;
        try {
            String sql = "select * from tb_user where LOGIN_NAME = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void addUser(User user) {

        // 1.定义sql
        String sql = "INSERT INTO tb_user(LOGIN_NAME, PASSWORD, PHONE, EMAIL, DISABLED, realName, birthday, gender,create_date) " +
                "VALUES(?,?,?,?,?,?,null,?,?)";
        // 2.执行sql
        template.update(sql,
                user.getLOGIN_NAME(),
                user.getPASSWORD(),
                user.getPHONE(),
                user.getEMAIL(),
                user.getDISABLED(),
                user.getRealName(),
                user.getGender(),
                new Date()
        );
    }


}
