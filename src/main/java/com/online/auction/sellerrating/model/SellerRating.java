
package com.online.auction.sellerrating.model;

import javax.persistence.*;

@Entity
@Table(name = "seller_rating")
public class SellerRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    public SellerRating() {}

    public SellerRating(Long userId, Long sellerId, Integer rating) {
        this.userId = userId;
        this.sellerId = sellerId;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
