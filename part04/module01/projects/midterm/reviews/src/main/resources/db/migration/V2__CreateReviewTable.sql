CREATE TABLE review (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    text TEXT NULL,
    created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    product_id BIGINT NOT NULL
);