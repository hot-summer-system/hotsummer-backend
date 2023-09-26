package com.hotsummer.luvme.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "product_id")
    private UUID productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_image")
    private String productImage;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product_skin_type_id", cascade = CascadeType.ALL)
    private List<ProductSkinType> productSkinTypes;
    @OneToMany(mappedBy = "product_category_id", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;
    @OneToMany(mappedBy = "characteristics_id", cascade = CascadeType.ALL)
    private List<ProductCharacteristics> productCharacteristics;
    @OneToMany(mappedBy = "product_ingredient_id", cascade = CascadeType.ALL)
    private List<ProductIngredient> productIngredients;
}
