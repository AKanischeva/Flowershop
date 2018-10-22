package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class FlowerDAOImpl {
    @PersistenceContext
    private EntityManager em;

    public List<Flower> getFlowers() {
        TypedQuery<Flower> query = em.createQuery("select f from Flower f", Flower.class);
        List<Flower> flowers = query.getResultList();

        return flowers;
    }

    public Flower getByName(String name) {
        TypedQuery<Flower> query = em.createQuery("select f from Flower f where f.name=:name", Flower.class);
        query.setParameter("name", name);
        Flower flower = query.getSingleResult();

        return flower;
    }

    public Flower update(Flower flower) {
        return null;
    }
}