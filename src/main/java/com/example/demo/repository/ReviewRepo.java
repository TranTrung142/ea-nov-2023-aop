package com.example.demo.repository;

import com.example.demo.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
}
