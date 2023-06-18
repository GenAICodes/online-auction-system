
package com.online.auction.sellerrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellerrating")
public class SellerRatingController {

    @Autowired
    private SellerRatingService sellerRatingService;

    @PostMapping("/{userId}/{sellerId}/{rating}")
    public ResponseEntity<Void> rateSeller(@PathVariable Long userId, @PathVariable Long sellerId, @PathVariable Integer rating) {
        sellerRatingService.rateSeller(userId, sellerId, rating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{sellerId}/rating")
    public ResponseEntity<Double> getSellerRating(@PathVariable Long sellerId) {
        Double rating = sellerRatingService.getSellerRating(sellerId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping("/{sellerId}/ratings")
    public ResponseEntity<List<Integer>> getSellerRatings(@PathVariable Long sellerId) {
        List<Integer> ratings = sellerRatingService.getSellerRatings(sellerId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
