package com.accenture.storage.be.DAO;

import com.accenture.storage.be.entity.order.Item;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDAOImpl implements ItemDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> getItems() {
        List<Item> flowers = new ArrayList<>();
        try {
            TypedQuery<Item> query = em.createQuery("select f from Item f", Item.class);
            flowers = query.getResultList();
            return flowers;
        } catch (NoResultException ex) {
            return flowers;
        }
    }

    @Override
    public List<Item> getByFilters(String theme, String director, String year, String student, String faculty) {
        TypedQuery<Item> query = em.createQuery("select f from Item f where " +
                "f.theme like :theme", Item.class);
        List<Item> items = query.getResultList();

        return items;
    }

    @Override
    public Item getById(Long id) {
        try {
            TypedQuery<Item> query = em.createQuery("select i from Item i where i.id=:id", Item.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Item create(Item item) {
        try {
            em.persist(item);
            return item;
        } catch (NoResultException ex) {
            return null;
        }
    }
}