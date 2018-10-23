package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.order.Order;

public interface OrderDAO {

    Order getOrderByID(Integer id);

    Order getOrderByNum(String num);

    boolean addOrder(Order order);

    boolean removeOrder(Order order);

}
