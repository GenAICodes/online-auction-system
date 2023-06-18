
package com.online.auction.service;

import com.online.auction.entity.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getBidsByAuctionId(Long auctionId);
    Bid createBid(Bid bid);
}
