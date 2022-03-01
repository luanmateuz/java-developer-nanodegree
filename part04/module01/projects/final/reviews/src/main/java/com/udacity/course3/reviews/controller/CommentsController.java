package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.ReviewService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final ReviewService reviewService;

    @PostMapping(value = "/reviews/{reviewId}")
    public ResponseEntity<Review> createCommentForReview(@PathVariable("reviewId") String reviewId,
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

    @GetMapping(value = "/reviews/{reviewId}")
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
