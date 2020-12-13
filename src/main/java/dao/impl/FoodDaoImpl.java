package dao.impl;

import bean.Food;
import dao.FoodDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class FoodDaoImpl implements FoodDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Food> findAll() {

        String sql = "select * from tb_food";
        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class));
        return foods;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tb_food ";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Food> findByPage(int start, int rows) {
        String sql = "select * from tb_food limit ?, ?";

        return template.query(sql,new BeanPropertyRowMapper<Food>(Food.class),start,rows);
    }

    @Override
    public void Save(Food food, String new_name) {
        String sql = "insert into tb_food values(null,?,?,?,?,?,?,now(),now(),0)";
        template.update(sql,food.getFood_name(),food.getFoodType_id(),food.getPrice(),food.getDiscount(),food.getRemark(),new_name);

    }

    @Override
    public List<Food> findByTypeId(Integer foodTypeId) {
        String sql = "select * from tb_food where disabled = ? and foodType_id = ?";
        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class), 0,foodTypeId);
        return foods;
    }
/*
    @Override
    public Food findById(int parseInt) {

        String sql = "select * from tb_food where id = ?";
        Food food = template.queryForObject(sql, new BeanPropertyRowMapper<Food>(Food.class), parseInt);
        return food;
    }*/

    @Override
    public void updateFood_1(Food food, String new_name) {
        String sql = "update tb_food set food_name = ?, foodType_id = ?,price = ?,  discount = ? ,remark = ?,img = ?,update_date = now() where id = ?";
        template.update(sql,food.getFood_name(),food.getFoodType_id(),food.getPrice(),food.getDiscount(),food.getRemark(),new_name,food.getId());
    }

    @Override
    public void updateFood(Food food) {
        String sql = "update tb_food set food_name = ?, foodType_id = ?,price = ?,  discount = ? ,remark = ?,update_date = now() where id = ?";
        template.update(sql,food.getFood_name(),food.getFoodType_id(),food.getPrice(),food.getDiscount(),food.getRemark(),food.getId());
    }

    @Override
    public Food findByFoodId(Integer foodId) {
        String sql = "select * from tb_food where id = ?";
        Food food = template.queryForObject(sql, new BeanPropertyRowMapper<Food>(Food.class), foodId);
        return food;
    }
}
