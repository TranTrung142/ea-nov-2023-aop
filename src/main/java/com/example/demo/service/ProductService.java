package com.example.demo.service;

import com.example.demo.dto.SearchProductsParams;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }
    public List<Product> findByPriceGreaterThan(Double price) {
        return productRepo.findByPriceGreaterThan(price);
    }
    public List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double price) {
        return productRepo.findByCategoryNameAndPriceLessThan(categoryName, price);
    }
    public List<Product> findByNameContains(String name) {
        return productRepo.findByNameContains(name);
    }
    public Product findProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }
}
