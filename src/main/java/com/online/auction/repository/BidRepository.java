
package com.online.auction.repository;

import com.online.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByAuctionIdOrderByAmountDesc(Long auctionId);
}
