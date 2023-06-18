
package com.online.auction.auction;

import com.online.auction.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByUserId(Long userId);

    List<Auction> findByTitleContainingIgnoreCase(String title);

    List<Auction> findByCategoryId(Long categoryId);

    List<Auction> findByEndTimeGreaterThanEqualOrderByEndTimeAsc(Long endTime);

    List<Auction> findByEndTimeLessThanOrderByEndTimeAsc(Long endTime);
}
