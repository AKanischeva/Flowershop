package com.accenture.storage.be.DAO;

import com.accenture.storage.be.entity.order.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemDAO {

    @Transactional
    Item create(Item item);

    List<Item> getItems();

    List <Item> getByFilters(String theme, String director, String year, String student, String faculty);

    Item getById(Long id);
}
