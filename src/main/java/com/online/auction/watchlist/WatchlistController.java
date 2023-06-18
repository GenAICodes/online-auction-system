
package com.online.auction.watchlist;

import com.online.auction.entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @Autowired
    private WatchlistNotificationService watchlistNotificationService;

    @PostMapping("/{userId}/{auctionId}")
    public ResponseEntity<Void> addToWatchlist(@PathVariable Long userId, @PathVariable Long auctionId) {
        watchlistService.addToWatchlist(userId, auctionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{auctionId}")
    public ResponseEntity<Void> removeFromWatchlist(@PathVariable Long userId, @PathVariable Long auctionId) {
        watchlistService.removeFromWatchlist(userId, auctionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Auction>> getWatchlist(@PathVariable Long userId) {
        List<Auction> watchlist = watchlistService.getWatchlist(userId);
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    @PostMapping("/{userId}/{auctionId}/notification")
    public ResponseEntity<Void> sendNotification(@PathVariable Long userId, @PathVariable Long auctionId, @RequestBody String message) {
        watchlistNotificationService.sendNotification(userId, auctionId, message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
