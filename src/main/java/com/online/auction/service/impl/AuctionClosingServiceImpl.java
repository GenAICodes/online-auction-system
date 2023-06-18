
package com.online.auction.service.impl;

import com.online.auction.entity.Auction;
import com.online.auction.entity.AuctionStatus;
import com.online.auction.entity.Bid;
import com.online.auction.repository.AuctionRepository;
import com.online.auction.repository.ClosedAuctionRepository;
import com.online.auction.service.AuctionClosingService;
import com.online.auction.service.BidService;
import com.online.auction.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AuctionClosingServiceImpl implements AuctionClosingService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private BidService bidService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ClosedAuctionRepository closedAuctionRepository;

    @Override
    public void closeAuction(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId).orElse(null);
        if (auction == null) {
            throw new RuntimeException("Auction not found");
        }
        if (auction.getStatus() != AuctionStatus.OPEN) {
            throw new RuntimeException("Auction is not open");
        }
        List<Bid> bids = bidService.getBidsByAuctionId(auctionId);
        if (bids.isEmpty()) {
            auction.setStatus(AuctionStatus.NO_BIDS);
            auctionRepository.save(auction);
            return;
        }
        Bid winningBid = bids.get(0);
        for (Bid bid : bids) {
            if (bid.getAmount().compareTo(winningBid.getAmount()) > 0) {
                winningBid = bid;
            }
        }
        auction.setWinningBid(winningBid);
        auction.setStatus(AuctionStatus.CLOSED);
        auctionRepository.save(auction);
        closedAuctionRepository.save(auction);
        emailService.sendEmail(auction.getSeller().getEmail(), "Auction Closed", "Your auction for " + auction.getItem().getName() + " has closed with a winning bid of " + winningBid.getAmount());
        emailService.sendEmail(winningBid.getBidder().getEmail(), "Auction Won", "Congratulations! You have won the auction for " + auction.getItem().getName() + " with a bid of " + winningBid.getAmount());
    }
}
