package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }
    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}
