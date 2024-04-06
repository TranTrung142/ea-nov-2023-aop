package com.example.demo.controller;


import com.example.demo.annotations.ExecutionTime;
import com.example.demo.dto.SearchProductsParams;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("")
    @ExecutionTime
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/greater-than-price")
    public List<Product> findByPriceGreaterThan(@RequestParam Double price) {
        return productService.findByPriceGreaterThan(price);
    }
    @GetMapping("/category-and-less-than-price")
    public List<Product> findByCategoryNameAndPriceLessThan(@RequestParam String categoryName,@RequestParam Double price) {
        return productService.findByCategoryNameAndPriceLessThan(categoryName, price);
    }
    @GetMapping("/name-contain")
    public List<Product> findByNameContains(@RequestParam String name) {
        return productService.findByNameContains(name);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        Category category = categoryService.findCategoryById(product.getCategory().getId());
        if (category == null) {
            return null;
        }
        if (product.getCategory().getName() != null) category.setName(product.getCategory().getName());
        product.setCategory(category);
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
