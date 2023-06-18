
package com.online.auction.repository;

import com.online.auction.entity.Auction;
import com.online.auction.entity.AuctionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByStatus(AuctionStatus status);
}
