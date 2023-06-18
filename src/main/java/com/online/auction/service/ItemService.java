
package com.online.auction.service;

import com.online.auction.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(Long id);

    Item createItem(Item item);

    Item updateItem(Item item);

    void deleteItem(Long id);
}
