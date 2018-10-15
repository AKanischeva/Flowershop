package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.entity.flower.Flower;

public interface OrderBusinessService {

    void addItem(Flower flower);

    void removeItem(Flower flower);

    double calculateSubtotalAndDiscount();
}
