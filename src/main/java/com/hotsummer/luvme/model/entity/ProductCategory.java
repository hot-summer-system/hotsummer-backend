package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ProductCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private int productCategoryId;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    List<Product> products;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    List<Category> categories;
}
