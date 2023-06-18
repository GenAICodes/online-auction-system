
package com.online.auction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ClosedAuction {
    private Long id;
    private Auction auction;
    private Bid winningBid;
    private LocalDateTime closedDate;
    private BigDecimal soldPrice;

    public ClosedAuction(Long id, Auction auction, Bid winningBid, LocalDateTime closedDate, BigDecimal soldPrice) {
        this.id = id;
        this.auction = auction;
        this.winningBid = winningBid;
        this.closedDate = closedDate;
        this.soldPrice = soldPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Bid winningBid) {
        this.winningBid = winningBid;
    }

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
    }

    public BigDecimal getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(BigDecimal soldPrice) {
        this.soldPrice = soldPrice;
    }
}
