package bean;

import java.util.Date;

public class DinnerTable {


    private int id;
    private String table_Name;
    private int table_status;
    private Date begin_use_date;
    private Date create_date;
    private Date update_date;
    private int disabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTable_Name() {
        return table_Name;
    }

    public void setTable_Name(String table_Name) {
        this.table_Name = table_Name;
    }

    public int getTable_status() {
        return table_status;
    }

    public void setTable_status(int table_status) {
        this.table_status = table_status;
    }

    public Date getBegin_use_date() {
        return begin_use_date;
    }

    public void setBegin_use_date(Date begin_use_date) {
        this.begin_use_date = begin_use_date;
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
        return "DinnerTable{" +
                "id=" + id +
                ", table_Name='" + table_Name + '\'' +
                ", table_status=" + table_status +
                ", begin_use_date=" + begin_use_date +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", disabled=" + disabled +
                '}';
    }
}
