
package com.online.auction.sellerrating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SellerRatingNotFoundException extends RuntimeException {

    public SellerRatingNotFoundException(Long sellerId) {
        super("Seller rating not found for seller id: " + sellerId);
    }
}
