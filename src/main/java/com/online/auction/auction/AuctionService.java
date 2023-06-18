
package com.online.auction.auction;

import com.online.auction.entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public void createAuction(Auction auction) {
        auctionRepository.save(auction);
    }

    public void updateAuction(Auction auction) {
        auctionRepository.save(auction);
    }

    public void deleteAuction(Long auctionId) {
        auctionRepository.deleteById(auctionId);
    }

    public Auction getAuction(Long auctionId) {
        return auctionRepository.findById(auctionId).orElse(null);
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> getAuctionsByUserId(Long userId) {
        return auctionRepository.findByUserId(userId);
    }

    public List<Auction> searchAuctionsByTitle(String title) {
        return auctionRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Auction> getAuctionsByCategoryId(Long categoryId) {
        return auctionRepository.findByCategoryId(categoryId);
    }

    public List<Auction> getActiveAuctions() {
        return auctionRepository.findByEndTimeGreaterThanEqualOrderByEndTimeAsc(System.currentTimeMillis());
    }

    public List<Auction> getExpiredAuctions() {
        return auctionRepository.findByEndTimeLessThanOrderByEndTimeAsc(System.currentTimeMillis());
    }
}
