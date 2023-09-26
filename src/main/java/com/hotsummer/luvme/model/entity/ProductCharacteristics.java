package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ProductCharacteristics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCharacteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristics_id")
    private int characteristicsId;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    List<ProductCharacteristics> productCharacteristics;
}
