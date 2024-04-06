package com.example.demo.service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;

    public List<Review> findByProductId(Long productId) {
        return reviewRepo.findByProductId(productId);
    }
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }
    public Review findReviewById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }
    public Review createReview(Review review) {
        return reviewRepo.save(review);
    }
    public Review updateReview(Review review) {
        return reviewRepo.save(review);
    }
    public void deleteReviewById(Long id) {
        reviewRepo.deleteById(id);
    }
}
