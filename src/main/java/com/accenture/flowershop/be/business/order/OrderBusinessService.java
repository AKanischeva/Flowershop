package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.entity.order.Item;

import java.math.BigDecimal;

public interface OrderBusinessService {

    void addItem(Item item);

    void removeItem(Item item);

    BigDecimal calculateSubtotalAndDiscount();
}
