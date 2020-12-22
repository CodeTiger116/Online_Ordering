package service.impl;

import bean.Food;
import bean.PageBean;
import dao.FoodDao;
import dao.impl.FoodDaoImpl;
import service.FoodService;

import java.util.List;
import java.util.Map;

public class FoodServiceImpl implements FoodService {

    private FoodDao dao = new FoodDaoImpl();

    @Override
    public List<Food> FindAll() {
        return dao.findAll();
    }

    @Override
    public PageBean<Food> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建空的PageBean对象
        PageBean<Food> pb = new PageBean<Food>();

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        int start = (currentPage - 1) * rows;

        //调用dao查询list集合
        List<Food> list = dao.findByPage(start,rows,condition);

        //计算总页码
        int totalPage = totalCount % rows  == 0 ? (totalCount / rows) : (totalCount / rows + 1);


        //设置
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void save(Food food, String new_name) {
        dao.Save(food,new_name);
    }

    @Override
    public List<Food> findByTypeId(Integer foodTypeId) {
        return dao.findByTypeId(foodTypeId);
    }

/*    @Override
    public Food findById(String id) {
        return dao.findById(Integer.parseInt(id));
    }*/

    @Override
    public void updateFood_1(Food food, String new_name) {
        dao.updateFood_1(food,new_name);
    }

    @Override
    public void updateFood(Food food) {

        dao.updateFood(food);
    }

    @Override
    public Food findByFoodId(Integer foodId) {
        return dao.findByFoodId(foodId);
    }

    @Override
    public List<Food> sortByPrice() {
        return dao.sortByPrice();
    }

    @Override
    public List<Food> searchByName(String searchName) {
        return dao.searchByName(searchName);
    }
}
