package bean;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String order_code;
    private int table_id;
    private double total_Price;
    private int order_Status;
    private Date order_Date;
    private Date pay_date;
    private int disabled;

    private DinnerTable dinnerTable;

    private List<OrderDetail> orderDetails;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public int getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(int order_Status) {
        this.order_Status = order_Status;
    }

    public Date getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(Date order_Date) {
        this.order_Date = order_Date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public DinnerTable getDinnerTable() {
        return dinnerTable;
    }

    public void setDinnerTable(DinnerTable dinnerTable) {
        this.dinnerTable = dinnerTable;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_code='" + order_code + '\'' +
                ", table_id=" + table_id +
                ", total_Price=" + total_Price +
                ", order_Status=" + order_Status +
                ", order_Date=" + order_Date +
                ", pay_date=" + pay_date +
                ", disabled=" + disabled +
                ", dinnerTable=" + dinnerTable +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
