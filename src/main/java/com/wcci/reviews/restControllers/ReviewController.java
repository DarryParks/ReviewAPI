package com.wcci.reviews.restControllers;

import com.wcci.reviews.entities.Category;
import com.wcci.reviews.entities.Review;
import com.wcci.reviews.respositories.CategoryRepository;
import com.wcci.reviews.respositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    final ReviewRepository reviewRepository;

    public ReviewController(final @Autowired ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping("/reviews")
    public @ResponseBody Review postReview(final @RequestBody Review review) {
        return reviewRepository.save(review);
    }
}