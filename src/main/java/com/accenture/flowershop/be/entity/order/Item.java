package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.math.BigDecimal;

public class Item {
    private Flower flower;
    private int amount;
    private BigDecimal subTotal;
}
