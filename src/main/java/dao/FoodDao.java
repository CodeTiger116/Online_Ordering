package dao;

import bean.Food;

import java.util.List;
import java.util.Map;

public interface FoodDao {
    /**
     * 查询所有
     * @return
     */
    List<Food> findAll();

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Food> findByPage(int start, int rows, Map<String, String[]> condition);

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

    /**
     * 价格排序
     * @return
     */
    List<Food> sortByPrice();


    /**
     * 关键字查询
     * @param searchName
     * @return
     */
    List<Food> searchByName(String searchName);

    /**
     * 逻辑删除
     * @param id
     * @param i
     */
    void deleteFood(String id, int i);

    /**
     * 按价格区间查询
     * @param condition
     * @return
     */
    List<Food> findByLeftRight(int left,int right);
}
