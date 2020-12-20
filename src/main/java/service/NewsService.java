package service;

import bean.Food;
import bean.News;

import java.util.List;


public interface NewsService {

    /**
     * 新增公告
     */
    void addNews(News news);

    /**
     * 查询全部
     * @return
     */
    List<News> FindAll();


    /**
     * 删除
     * @param id
     */
    void DelNews(String id);

    /**
     * 根据id查询
     * @param parseInt
     * @return
     */
    News findByNewsId(int parseInt);

    /**
     * 修改
     * @param id
     */
    void UpdateNews(News news);
}
