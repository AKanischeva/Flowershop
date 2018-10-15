package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.math.BigDecimal;
import java.util.List;

public interface FlowerDAO {

    Flower getFlower(String name);

    boolean addFlower(Flower flower);

    boolean removeFlower(Flower flower);

    List getFlowersByPrice(BigDecimal minPrice, BigDecimal maxPrice);
}
