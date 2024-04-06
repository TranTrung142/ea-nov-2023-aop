package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private int rating;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
//    @Fetch(FetchMode.JOIN)
    private List<Review> reviews;
}
