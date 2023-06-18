
package com.online.auction.history.impl;

import com.online.auction.entity.Bid;
import com.online.auction.history.BiddingHistoryService;
import com.online.auction.history.BiddingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingHistoryServiceImpl implements BiddingHistoryService {

    @Autowired
    private BiddingHistoryRepository biddingHistoryRepository;

    @Override
    public List<Bid> getBiddingHistoryByUserId(Long userId) {
        return biddingHistoryRepository.findByUserIdOrderByBidTimeDesc(userId);
    }

    @Override
    public List<Bid> getBiddingHistoryByAuctionId(Long auctionId) {
        return biddingHistoryRepository.findByAuctionIdOrderByBidTimeDesc(auctionId);
    }

    @Override
    public List<Bid> getWinningBidsByUserId(Long userId) {
        return biddingHistoryRepository.findWinningBidsByUserId(userId);
    }
}
