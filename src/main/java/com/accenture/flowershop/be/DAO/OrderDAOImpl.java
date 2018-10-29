package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Order> getOrders() {
        List<Order> orders = null;
        try {
            TypedQuery<Order> query = em.createQuery("select o from Order o", Order.class);
            orders = query.getResultList();
            return orders;
        } catch (NoResultException ex) {
            return null;
        }

    }


    @Override
    public Order create(Order order) {
        try {
            em.persist(order);
            return order;
        } catch (NoResultException ex) {
            return null;
        }
    }


    @Override
    public void update(Order order) {

    }


    @Override
    public void delete(Long id) {

    }


    @Override
    public List<Order> getOrderByUser(User user) {
        List<Order> orders = null;
        try {
            TypedQuery<Order> query = em.createQuery("select o from Order o where o.user=:user", Order.class);
            query.setParameter("user", user);
            orders = query.getResultList();
            return orders;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
