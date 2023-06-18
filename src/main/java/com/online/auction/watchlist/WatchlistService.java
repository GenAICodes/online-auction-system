
package com.online.auction.watchlist;

import com.online.auction.entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistDatabase watchlistDatabase;

    public void addToWatchlist(Long userId, Long auctionId) {
        watchlistDatabase.addToWatchlist(userId, auctionId);
    }

    public void removeFromWatchlist(Long userId, Long auctionId) {
        watchlistDatabase.removeFromWatchlist(userId, auctionId);
    }

    public List<Auction> getWatchlist(Long userId) {
        return watchlistDatabase.getWatchlist(userId);
    }

    public void sendNotification(Long userId, Long auctionId, String message) {
        // Implementation for sending notification
    }
}
