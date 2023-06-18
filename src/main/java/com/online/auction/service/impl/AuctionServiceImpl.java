
package com.online.auction.service.impl;

import com.online.auction.entity.Auction;
import com.online.auction.entity.AuctionStatus;
import com.online.auction.repository.AuctionRepository;
import com.online.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction getAuctionById(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction updateAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public List<Auction> getAuctionsByStatus(AuctionStatus status) {
        return auctionRepository.findByStatus(status);
    }
}
