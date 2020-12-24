package dao.impl;

import bean.Food;
import dao.FoodDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoodDaoImpl implements FoodDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Food> findAll() {

        String sql = "select * from tb_food";
        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class));
        return foods;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1、定义模板初始化sql
        String sql = "select count(*) from tb_food where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2、遍历map
        Set<String> keySet = condition.keySet();

        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet){

            //排除分页的条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//条件的值
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Food> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from tb_food where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2、遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet){

            //排除分页的条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        return template.query(sb.toString(),new BeanPropertyRowMapper<Food>(Food.class),params.toArray());
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

    @Override
    public List<Food> sortByPrice() {
        String sql = "SELECT * FROM tb_food ORDER BY price ASC;";
        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class));
        return foods;
    }

    @Override
    public List<Food> searchByName(String searchName) {
        String sql = "select * from tb_food where food_name like ?";

        List<Object> params = new ArrayList<Object>();
        params.add("%"+searchName+"%");

        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class),params.toArray());
        return foods;
    }

    @Override
    public void deleteFood(String id, int i) {
        String sql = "update tb_food set DISABLED = ? where ID = ?";
        template.update(sql,i,id);
    }

    @Override
    public List<Food> findByLeftRight(int left ,int right) {

        String sql = "select * from tb_food where price between ? and ?  ORDER BY price ASC;";
        List<Food> foods = template.query(sql, new BeanPropertyRowMapper<Food>(Food.class), left, right);

        return foods;
    }
}
