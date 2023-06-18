
package com.online.auction.repository;

import com.online.auction.entity.ClosedAuction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClosedAuctionRepository extends JpaRepository<ClosedAuction, Long> {
    List<ClosedAuction> findBySellerIdOrderByClosedDateDesc(Long sellerId);
}
