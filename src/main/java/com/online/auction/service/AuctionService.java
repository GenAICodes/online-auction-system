
package com.online.auction.service;

import com.online.auction.entity.Auction;

import java.util.List;

public interface AuctionService {
    List<Auction> getAllAuctions();

    Auction getAuctionById(Long id);

    Auction createAuction(Auction auction);

    Auction updateAuction(Auction auction);

    void deleteAuction(Long id);
}
