
CREATE TABLE seller_rating (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    seller_id BIGINT NOT NULL,
    rating INT NOT NULL
);
