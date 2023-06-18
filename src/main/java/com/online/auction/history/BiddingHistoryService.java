
package com.online.auction.history;

import java.util.List;

public interface BiddingHistoryService {
    List<BiddingHistory> getBiddingHistoryByUserId(Long userId);
    List<BiddingHistory> getBiddingHistoryByAuctionId(Long auctionId);
    List<BiddingHistory> getWinningBidsByUserId(Long userId);
}
