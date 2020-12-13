package dao;

import bean.FoodType;

import java.util.List;

public interface FoodTypeDao {
    List<FoodType> findAll();

    List<FoodType> findFoodType();
}
