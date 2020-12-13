package bean;

import java.util.Date;

public class FoodType {

    private int id;
    private String type_name;
    private Date create_date;
    private Date update_date;
    private int disabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", disabled=" + disabled +
                '}';
    }
}
