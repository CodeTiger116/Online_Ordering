package service;

import bean.Food;
import bean.PageBean;

import java.util.List;
import java.util.Map;

public interface FoodService {

    /**
     * 查找所有
     * @return
     */
    List<Food> FindAll();


    /**
     * 分页查询
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Food> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 添加菜品
     * @param food
     * @param new_name
     */
    void save(Food food, String new_name);

    /**
     * 查询默认（第一个未删除）菜系的菜品
     * @param foodTypeId
     * @return
     */
    List<Food> findByTypeId(Integer foodTypeId);


    /**
     * 修改菜品（用户修改了图片）
     * @param food
     * @param new_name
     */
    void updateFood_1(Food food, String new_name);

    /**
     * 修改菜品（用户没有修改图片）
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
     * 价格升序查询
     * @return
     */
    List<Food> sortByPrice();

    /**
     * 主页搜索查询
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
     * @param
     * @return
     */
    List<Food> searchByLeftRight(int left, int right);
}
