package com.hotsummer.luvme.model.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "how_to_use_product")
    private String howToUse;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSkinType> productSkinTypes;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCharacteristics> productCharacteristics;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductIngredient> productIngredients;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Favorite> favorites;
}
