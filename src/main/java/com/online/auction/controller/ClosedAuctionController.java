
package com.online.auction.controller;

import com.online.auction.entity.Auction;
import com.online.auction.entity.AuctionStatus;
import com.online.auction.repository.ClosedAuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/closed-auctions")
public class ClosedAuctionController {

    @Autowired
    private ClosedAuctionRepository closedAuctionRepository;

    @GetMapping("")
    public ResponseEntity<List<Auction>> getAllClosedAuctions() {
        List<Auction> closedAuctions = closedAuctionRepository.findByStatus(AuctionStatus.CLOSED);
        return new ResponseEntity<>(closedAuctions, HttpStatus.OK);
    }
}
