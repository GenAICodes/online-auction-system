
package com.online.auction.controller;

import com.online.auction.entity.Bid;
import com.online.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/{auctionId}")
    public ResponseEntity<List<Bid>> getBidsByAuctionId(@PathVariable Long auctionId) {
        List<Bid> bids = bidService.getBidsByAuctionId(auctionId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        Bid createdBid = bidService.createBid(bid);
        return new ResponseEntity<>(createdBid, HttpStatus.CREATED);
    }
}
