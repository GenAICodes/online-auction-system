
package com.online.auction.controller;

import com.online.auction.service.AuctionClosingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auctions")
public class AuctionClosingController {

    @Autowired
    private AuctionClosingService auctionClosingService;

    @PostMapping("/{id}/close")
    public ResponseEntity<String> closeAuction(@PathVariable Long id) {
        auctionClosingService.closeAuction(id);
        return new ResponseEntity<>("Auction closed successfully", HttpStatus.OK);
    }
}
