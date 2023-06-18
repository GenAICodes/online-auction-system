
package com.online.auction.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double startingBid;

    private LocalDateTime startTime;

    // getters and setters
    // Your complete code here
}
