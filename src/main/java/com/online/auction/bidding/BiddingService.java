
package com.online.auction.bidding;

import com.online.auction.entity.Auction;
import com.online.auction.entity.Bid;
import com.online.auction.watchlist.WatchlistNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiddingService {

    @Autowired
    private WatchlistNotificationService watchlistNotificationService;

    public void addBid(Auction auction, Bid bid) {
        auction.addBid(bid);
        watchlistNotificationService.sendNotification(auction.getUserId(), auction.getId(), bid.getAmount());
    }
}
