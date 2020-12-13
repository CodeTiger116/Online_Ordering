package dao;

import bean.Food;

import java.util.List;

public interface FoodDao {
    /**
     * 查询所有
     * @return
     */
    List<Food> findAll();

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    List<Food> findByPage(int start, int rows);

    /**
     * 添加菜品
     * @param food
     * @param new_name
     */
    void Save(Food food, String new_name);

    /**
     * 查询第一个未删除的菜系的菜品
     * @param foodTypeId
     * @return
     */
    List<Food> findByTypeId(Integer foodTypeId);

    /**
     * 根据id查询菜品
     * @param parseInt
     * @return
     */
/*    Food findById(int parseInt);*/

    /**
     * 修改菜品1
     * @param food
     * @param new_name
     */
    void updateFood_1(Food food, String new_name);

    /**
     * 修改菜品2
     * @param food
     */
    void updateFood(Food food);

    /**
     * 通过菜品id查询
     * @param foodId
     * @return
     */
    Food findByFoodId(Integer foodId);
}
