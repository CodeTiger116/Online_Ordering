package dao;

import bean.Food;
import bean.News;

import java.util.List;


public interface NewsDao {

    /**
     * 新增
     * @param news
     */
    void addNews(News news);

    /**
     * 查询
     * @return
     */
    List<News> findAll();

    /**
     * 删除
     * @param parseInt
     */
    void delNews(int parseInt);

    /**
     *
     * @param id
     * @return
     */
    News findByNewsId(int id);

    /**
     * 修改
     * @param parseInt
     */
    void updateNews(News news);
}
