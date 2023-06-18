
package com.online.auction.sellerrating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRatingRepository extends JpaRepository<SellerRating, Long> {

    List<SellerRating> findBySellerId(Long sellerId);
}
