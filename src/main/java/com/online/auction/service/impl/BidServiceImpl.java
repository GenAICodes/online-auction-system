
package com.online.auction.service.impl;

import com.online.auction.entity.Bid;
import com.online.auction.repository.BidRepository;
import com.online.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getBidsByAuctionId(Long auctionId) {
        return bidRepository.findByAuctionIdOrderByAmountDesc(auctionId);
    }

    @Override
    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }
}
