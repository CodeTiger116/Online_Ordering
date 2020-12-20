package service.impl;

import bean.Food;
import bean.News;
import dao.DinnerTableDao;
import dao.NewsDao;
import dao.impl.DinnerTableDaoImpl;
import dao.impl.NewsDaoImpl;
import service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao dao = new NewsDaoImpl();

    @Override
    public void addNews(News news) {
        dao.addNews(news);
    }

    @Override
    public List<News> FindAll() {
        return dao.findAll();
    }

    @Override
    public void DelNews(String id) {
        dao.delNews(Integer.parseInt(id));
    }

    @Override
    public News findByNewsId(int id) {
        return dao.findByNewsId(id);
    }

    @Override
    public void UpdateNews(News news) {
        dao.updateNews(news);
    }
}
