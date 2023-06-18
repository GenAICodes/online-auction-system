
package com.online.auction.service;

import com.online.auction.entity.Auction;
import com.online.auction.entity.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuctionMonitoringService {

    private final Map<Long, Auction> auctions = new HashMap<>();

    @Autowired
    private BidService bidService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void addAuction(Auction auction) {
        auctions.put(auction.getId(), auction);
    }

    public void updateBid(Bid bid) {
        Bid existingBid = bidService.getBidById(bid.getId());
        if (existingBid != null && existingBid.getAmount() < bid.getAmount()) {
            existingBid.setAmount(bid.getAmount());
            bidService.updateBid(existingBid);
            Auction auction = auctions.get(existingBid.getAuctionId());
            if (auction != null) {
                messagingTemplate.convertAndSend("/topic/auction/" + auction.getId(), auction);
            }
        }
    }
}
