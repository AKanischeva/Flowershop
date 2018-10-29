package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.DAO.OrderDAO;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class OrderBusinessServiceImpl implements OrderBusinessService {
    @Autowired
    OrderDAO dao;

    @Override
    public Order newOrder(User user, BigDecimal subTotal) {
        Order o = new Order(user, subTotal);
        dao.create(o);
        return o;
    }


    @Override
    public List<Order> getAllOrders() {
        List<Order> o = dao.getOrders();
        return o;
    }


    @Override
    public void updateStatus(Order order) {

    }


    @Override
    public void deleteOrder(Order order) {

    }


    @Override
    public List<Order> getOrdersByUser(User user) {
        List<Order> o = dao.getOrderByUser(user);
        return o;
    }
}