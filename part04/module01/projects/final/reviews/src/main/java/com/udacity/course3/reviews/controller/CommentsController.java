package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.ReviewService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    private final ReviewService reviewService;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") String reviewId,
            @RequestBody
                    Comment comment) {
        Optional<Review> byId = this.reviewService.findById(reviewId);
        if (byId.isPresent()) {
            Review review = byId.get();
            review.getCommentList().add(comment);
            Review save = this.reviewService.save(review);

            return ResponseEntity.ok(save);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listCommentsForReview(
            @PathVariable("reviewId") String reviewId) {
        Optional<Review> byId = this.reviewService.findById(reviewId);
        if (byId.isPresent()) {
            Review review = byId.get();

            return ResponseEntity.ok(review.getCommentList());
        }

        return ResponseEntity.notFound().build();
    }
}