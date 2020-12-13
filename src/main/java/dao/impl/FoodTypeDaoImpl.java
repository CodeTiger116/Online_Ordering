package dao.impl;

import bean.FoodType;
import dao.FoodTypeDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class FoodTypeDaoImpl implements FoodTypeDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<FoodType> findAll() {

        String sql = "select * from tb_food_type";

        List<FoodType> foodTypes = template.query(sql, new BeanPropertyRowMapper<FoodType>(FoodType.class));
        return foodTypes;
    }

    @Override
    public List<FoodType> findFoodType() {
       String sql = "select * from tb_food_type where disabled = ?";
        List<FoodType> foodTypes = template.query(sql, new BeanPropertyRowMapper<FoodType>(FoodType.class), 0);
        return foodTypes;
    }
}
