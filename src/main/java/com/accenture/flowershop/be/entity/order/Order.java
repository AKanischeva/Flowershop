package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.fe.enums.order.Status;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int orderNum;
    private double orderSubtotal;
    private List<Item> items;
    private Date orderDate;
    private Date orderCloseDate;
    private Status orderStatus;

    public Order(int id, int orderNum, double orderSum, List<Item> items, Date orderDate, Date orderCloseDate, Status orderStatus) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderSubtotal = orderSum;
        this.items = items;
        this.orderDate = orderDate;
        this.orderCloseDate = orderCloseDate;
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderCloseDate() {
        return orderCloseDate;
    }

    public void setOrderCloseDate(Date orderCloseDate) {
        this.orderCloseDate = orderCloseDate;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getOrderSum() {
        return orderSubtotal;
    }

    public void setOrderSum(double orderSum) {
        this.orderSubtotal = orderSum;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
