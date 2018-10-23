package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.order.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order getOrderByID(Integer id) {
        return null;
    }

    @Override
    public Order getOrderByNum(String num) {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean removeOrder(Order order) {
        return false;
    }
}
