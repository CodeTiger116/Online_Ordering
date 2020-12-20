package bean;

import java.util.Date;

public class News {
    int id;
    String title;
    Date push_date;
    Date update_date;
    String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPush_date() {
        return push_date;
    }

    public void setPush_date(Date push_date) {
        this.push_date = push_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", push_date=" + push_date +
                ", update_date=" + update_date +
                ", content='" + content + '\'' +
                '}';
    }
}
