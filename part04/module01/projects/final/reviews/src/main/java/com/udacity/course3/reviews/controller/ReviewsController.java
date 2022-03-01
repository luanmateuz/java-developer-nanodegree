package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.ProductService;
import com.udacity.course3.reviews.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewService reviewService;
    private final ProductService productService;

    @PostMapping(value = "/products/{productId}")
    public ResponseEntity<Review> createReviewForProduct(@PathVariable("productId") Long productId,
            @RequestBody Review review) {
        Product byId = this.productService.findById(productId);

        review.setProduct(byId);
        Review save = this.reviewService.save(review);

        return ResponseEntity.ok(save);
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<List<Review>> listReviewsForProduct(
            @PathVariable("productId") Long productId) {
        List<Review> allByProduct = this.reviewService.findByProductId(productId);
        return ResponseEntity.ok(allByProduct);
    }
}
