package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.ProductService;
import com.udacity.course3.reviews.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
@RequiredArgsConstructor
public class ReviewsController {

    // TODO: Wire JPA repositories here
    private final ReviewService reviewService;
    private final ProductService productService;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Long productId,
            @RequestBody Review review) {
        Product byId = this.productService.findById(productId);

        review.setProduct(byId);
        Review save = this.reviewService.save(review);

        return ResponseEntity.ok(save);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> listReviewsForProduct(
            @PathVariable("productId") Long productId) {
        List<Review> allByProduct = this.reviewService.findByProductId(productId);
        return ResponseEntity.ok(allByProduct);
    }
}