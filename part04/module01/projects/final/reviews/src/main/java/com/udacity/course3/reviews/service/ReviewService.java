package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.exception.NotFoundException;
import com.udacity.course3.reviews.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    public Optional<Review> findById(String reviewId) {
        return Optional.ofNullable(this.reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NotFoundException("Review not found.")));
    }

    public List<Review> findByProductId(Long productId) {
        Long id = this.productService.findById(productId).getId();
        return this.reviewRepository.findByProductId(id);
    }
}
