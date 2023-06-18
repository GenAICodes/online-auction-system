
package com.online.auction.sellerrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerRatingService {

    @Autowired
    private SellerRatingRepository sellerRatingRepository;

    public void rateSeller(Long userId, Long sellerId, Integer rating) {
        SellerRating sellerRating = new SellerRating(userId, sellerId, rating);
        sellerRatingRepository.save(sellerRating);
    }

    public Double getSellerRating(Long sellerId) {
        List<SellerRating> ratings = sellerRatingRepository.findBySellerId(sellerId);
        if (ratings.isEmpty()) {
            return null;
        }
        double sum = 0;
        for (SellerRating rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }

    public List<Integer> getSellerRatings(Long sellerId) {
        List<SellerRating> ratings = sellerRatingRepository.findBySellerId(sellerId);
        return ratings.stream().map(SellerRating::getRating).toList();
    }
}
