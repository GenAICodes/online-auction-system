
package com.online.auction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bid {
    private Long id;
    private User bidder;
    private Auction auction;
    private BigDecimal amount;
    private LocalDateTime createdDate;

    // Constructor, getters and setters
}
