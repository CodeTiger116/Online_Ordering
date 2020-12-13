package service.impl;

import bean.FoodType;
import dao.FoodTypeDao;
import dao.impl.FoodTypeDaoImpl;
import service.FoodTypeService;

import java.util.List;

public class FoodTypeServiceImpl implements FoodTypeService {

    private FoodTypeDao dao = new FoodTypeDaoImpl();

    @Override
    public List<FoodType> FindAll() {
        return dao.findAll();
    }

    @Override
    public List<FoodType> findFoodType() {
        return dao.findFoodType();
    }

}
