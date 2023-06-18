
package com.online.auction.history;

import com.online.auction.entity.Bid;
import com.online.auction.history.impl.BiddingHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bidding-history")
public class BiddingHistoryController {

    @Autowired
    private BiddingHistoryServiceImpl biddingHistoryService;

    @GetMapping("/user/{userId}")
    public List<Bid> getBiddingHistoryByUserId(@PathVariable Long userId) {
        return biddingHistoryService.getBiddingHistoryByUserId(userId);
    }

    @GetMapping("/auction/{auctionId}")
    public List<Bid> getBiddingHistoryByAuctionId(@PathVariable Long auctionId) {
        return biddingHistoryService.getBiddingHistoryByAuctionId(auctionId);
    }

    @GetMapping("/user/{userId}/winning-bids")
    public List<Bid> getWinningBidsByUserId(@PathVariable Long userId) {
        return biddingHistoryService.getWinningBidsByUserId(userId);
    }
}
