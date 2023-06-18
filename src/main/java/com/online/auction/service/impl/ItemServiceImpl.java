
package com.online.auction.service.impl;

import com.online.auction.entity.Item;
import com.online.auction.repository.ItemRepository;
import com.online.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
