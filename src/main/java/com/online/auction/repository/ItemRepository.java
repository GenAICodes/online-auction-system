
package com.online.auction.repository;

import com.online.auction.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findById(long id);
}
