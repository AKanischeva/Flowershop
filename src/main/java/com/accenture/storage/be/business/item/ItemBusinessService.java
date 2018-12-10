package com.accenture.storage.be.business.item;

import com.accenture.storage.be.entity.order.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemBusinessService {

    List<Item> itemList();

    Item upload(String student, String theme, String director, String year, String faculty, String description, byte[] upload, String filename);

    Item getById(Long id);
}
