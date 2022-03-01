package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import java.util.List;
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

    public List<Review> findByProductId(Long productId) {
        Long id = this.productService.findById(productId).getId();
        return this.reviewRepository.findByProductId(id);
    }
}
