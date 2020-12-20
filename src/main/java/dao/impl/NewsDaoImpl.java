package dao.impl;

import bean.Food;
import bean.News;
import dao.NewsDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class NewsDaoImpl implements NewsDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addNews(News news) {
        String sql = "INSERT INTO news VALUES(null,?,now(),now(),?)";
        template.update(sql,news.getTitle(),news.getContent());
    }

    @Override
    public List<News> findAll() {
        String sql = "select * from news";
        List<News> news = template.query(sql, new BeanPropertyRowMapper<News>(News.class));
        return news;
    }

    @Override
    public void delNews(int id) {
        String sql = "delete from news where id = ?";
        template.update(sql,id);

    }

    @Override
    public News findByNewsId(int id) {
        String sql = "select * from news where id = ?";
        News news = template.queryForObject(sql, new BeanPropertyRowMapper<News>(News.class), id);
        return news;
    }

    @Override
    public void updateNews(News news) {
        String sql = "update news set title = ?, content = ?, update_date = now() where id = ?";
        template.update(sql,news.getTitle(),news.getContent(),news.getId());
    }
}
