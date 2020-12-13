package service;

import bean.FoodType;

import java.util.List;

public interface FoodTypeService {
    /**
     *
     * @return
     */
    List<FoodType> FindAll();


    /**
     * 查询未被删除的菜系
     * @return
     */
    List<FoodType> findFoodType();
}
