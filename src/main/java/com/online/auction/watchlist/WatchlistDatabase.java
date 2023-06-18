
package com.online.auction.watchlist;

import com.online.auction.entity.Auction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WatchlistDatabase {

    private Map<Long, List<Auction>> watchlistMap = new HashMap<>();

    public void addToWatchlist(Long userId, Long auctionId) {
        List<Auction> watchlist = watchlistMap.getOrDefault(userId, new ArrayList<>());
        watchlist.add(new Auction(auctionId));
        watchlistMap.put(userId, watchlist);
    }

    public void removeFromWatchlist(Long userId, Long auctionId) {
        List<Auction> watchlist = watchlistMap.getOrDefault(userId, new ArrayList<>());
        watchlist.removeIf(auction -> auction.getId().equals(auctionId));
        watchlistMap.put(userId, watchlist);
    }

    public List<Auction> getWatchlist(Long userId) {
        return watchlistMap.getOrDefault(userId, new ArrayList<>());
    }
}
