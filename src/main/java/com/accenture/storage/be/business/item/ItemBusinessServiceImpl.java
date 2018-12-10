package com.accenture.storage.be.business.item;

import com.accenture.storage.be.DAO.ItemDAO;
import com.accenture.storage.be.entity.order.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    ItemDAO dao;

    @Override
    public List<Item> itemList() {
        return dao.getItems();
    }

    @Override
    public Item upload(String student, String theme, String director, String year, String faculty, String description, byte[] upload, String filename) {
        try {
            Item i = new Item(student, theme, director, year, faculty, description, upload, filename);
            dao.create(i);
            return i;
            //TODO normal catch
        } catch (Exception ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Item getById(Long id) {
        return dao.getById(id);
    }
}
