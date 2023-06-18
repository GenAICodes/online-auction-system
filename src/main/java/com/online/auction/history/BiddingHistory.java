
    package com.online.auction.history;

    import com.online.auction.entity.Auction;
    import com.online.auction.entity.User;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;

    public class BiddingHistory {
        private Long id;
        private User user;
        private Auction auction;
        private BigDecimal amount;
        private LocalDateTime bidTime;
        private Boolean isWinningBid;

        public BiddingHistory(Long id, User user, Auction auction, BigDecimal amount, LocalDateTime bidTime, Boolean isWinningBid) {
            this.id = id;
            this.user = user;
            this.auction = auction;
            this.amount = amount;
            this.bidTime = bidTime;
            this.isWinningBid = isWinningBid;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Auction getAuction() {
            return auction;
        }

        public void setAuction(Auction auction) {
            this.auction = auction;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public LocalDateTime getBidTime() {
            return bidTime;
        }

        public void setBidTime(LocalDateTime bidTime) {
            this.bidTime = bidTime;
        }

        public Boolean getWinningBid() {
            return isWinningBid;
        }

        public void setWinningBid(Boolean winningBid) {
            isWinningBid = winningBid;
        }
    }
