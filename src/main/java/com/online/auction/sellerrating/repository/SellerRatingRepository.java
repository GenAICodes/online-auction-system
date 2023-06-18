
package com.online.auction.sellerrating.repository;

import com.online.auction.sellerrating.SellerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRatingRepository extends JpaRepository<SellerRating, Long> {
    List<SellerRating> findBySellerId(Long sellerId);
}
