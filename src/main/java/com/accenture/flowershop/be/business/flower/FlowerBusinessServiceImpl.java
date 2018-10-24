package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.DAO.FlowerDAO;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FlowerBusinessServiceImpl implements FlowerBusinessService {

    @Autowired
    FlowerDAO dao;

    @Override
    public boolean checkAvailability(String name, Integer amount) {
        return false;
    }

    @Override
    public Flower getFlower(String name) {
        return null;
    }

    @Override
    public List<Flower> getFlowerByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return null;
    }

    @Override
    public void updateFlowersQuantity(Long id, Integer quantity) {

    }

    @Override
    public List<Flower> flowersList() {
        return dao.getFlowers();
    }
}
