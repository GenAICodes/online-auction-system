
package com.online.auction.history;

import com.online.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingHistoryRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByUserIdOrderByBidTimeDesc(Long userId);

    List<Bid> findByAuctionIdOrderByBidTimeDesc(Long auctionId);

    List<Bid> findWinningBidsByUserId(Long userId);
}
