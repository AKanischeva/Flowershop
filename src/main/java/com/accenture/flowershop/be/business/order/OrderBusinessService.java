package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface OrderBusinessService {
    @Transactional
    Order newOrder(User user, BigDecimal subTotal);

    @Transactional
    List<Order> getAllOrders();

    void updateStatus(Order order);

    void deleteOrder(Order order);

    List<Order> getOrdersByUser(User user);
}