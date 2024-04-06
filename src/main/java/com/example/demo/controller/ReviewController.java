package com.example.demo.controller;

import com.example.demo.annotations.ExecutionTime;
import com.example.demo.dto.ReviewRequest;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.entity.User;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/by-product")
    List<Review> findByProductId(@RequestParam Long productId) {
        return reviewService.findByProductId(productId);
    }

    @GetMapping("")
    @ExecutionTime
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review findReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id);
    }

    @PostMapping
    public Review createReview(@RequestBody ReviewRequest review) {
        Review newReview = new Review();
        newReview.setComment(review.getComment());
        User user = new User();
        user.setId(review.getUserId());
        newReview.setUser(user);
        Product product = new Product();
        product.setId(review.getProductId());
        newReview.setProduct(product);

        return reviewService.createReview(newReview);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review oldReview = reviewService.findReviewById(id);
        if (oldReview == null) return null;
        review.setId(id);
        review.setUser(oldReview.getUser());
        review.setProduct(oldReview.getProduct());
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }
}
