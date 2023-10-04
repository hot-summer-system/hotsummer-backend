package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ProductSkinType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_skin_type_id")
    private int productSkinTypeId;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "suitable_skin_type_id", referencedColumnName = "suitable_skin_type_id")
    private SuitableSkinType suitableSkinType;
}
