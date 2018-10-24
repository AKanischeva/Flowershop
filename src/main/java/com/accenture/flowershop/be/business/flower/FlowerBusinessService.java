package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface FlowerBusinessService {

    boolean checkAvailability(String name, Integer amount);

    Flower getFlower(String name);

    List<Flower> getFlowerByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    void updateFlowersQuantity(Long id, Integer quantity);

    List<Flower> flowersList();

}
