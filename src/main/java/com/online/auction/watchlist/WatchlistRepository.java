
package com.online.auction.watchlist;

import com.online.auction.entity.Auction;

import java.util.List;

public interface WatchlistRepository {

    void addToWatchlist(Long userId, Long auctionId);

    void removeFromWatchlist(Long userId, Long auctionId);

    List<Auction> getWatchlist(Long userId);
}
