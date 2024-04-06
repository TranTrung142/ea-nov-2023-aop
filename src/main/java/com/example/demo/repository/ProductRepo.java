package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double price);
    List<Product> findByNameContains(String name);
}
