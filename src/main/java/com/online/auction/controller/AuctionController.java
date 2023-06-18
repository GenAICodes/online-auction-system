
package com.online.auction.controller;

import com.online.auction.entity.Auction;
import com.online.auction.service.AuctionClosingService;
import com.online.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionClosingService auctionClosingService;

    @GetMapping("/{id}")
    public ResponseEntity<Auction> getAuctionById(@PathVariable Long id) {
        Auction auction = auctionService.getAuctionById(id);
        if (auction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(auction, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        Auction createdAuction = auctionService.createAuction(auction);
        return new ResponseEntity<>(createdAuction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable Long id, @RequestBody Auction auction) {
        Auction updatedAuction = auctionService.updateAuction(id, auction);
        if (updatedAuction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAuction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/close")
    public ResponseEntity<String> closeAuction(@PathVariable Long id) {
        auctionClosingService.closeAuction(id);
        return new ResponseEntity<>("Auction closed successfully", HttpStatus.OK);
    }
}
