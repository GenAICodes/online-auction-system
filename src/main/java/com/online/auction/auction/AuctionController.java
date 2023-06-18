
package com.online.auction.auction;

import com.online.auction.entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @PostMapping
    public ResponseEntity<Void> createAuction(@RequestBody Auction auction) {
        auctionService.createAuction(auction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateAuction(@RequestBody Auction auction) {
        auctionService.updateAuction(auction);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{auctionId}")
    public ResponseEntity<Void> deleteAuction(@PathVariable Long auctionId) {
        auctionService.deleteAuction(auctionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<Auction> getAuction(@PathVariable Long auctionId) {
        Auction auction = auctionService.getAuction(auctionId);
        return new ResponseEntity<>(auction, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Auction>> getAllAuctions() {
        List<Auction> auctions = auctionService.getAllAuctions();
        return new ResponseEntity<>(auctions, HttpStatus.OK);
    }
}
