
package com.online.auction.sellerrating.controller;

import com.online.auction.sellerrating.exception.SellerRatingNotFoundException;
import com.online.auction.sellerrating.service.SellerRatingService;
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
        try {
            Double rating = sellerRatingService.getSellerRating(sellerId);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } catch (SellerRatingNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{sellerId}/ratings")
    public ResponseEntity<List<Integer>> getSellerRatings(@PathVariable Long sellerId) {
        try {
            List<Integer> ratings = sellerRatingService.getSellerRatings(sellerId);
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        } catch (SellerRatingNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
