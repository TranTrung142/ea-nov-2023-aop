package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductsParams {
    private Double minPrice;
    private Double maxPrice;
    private String category;
    private String keyword;
}
