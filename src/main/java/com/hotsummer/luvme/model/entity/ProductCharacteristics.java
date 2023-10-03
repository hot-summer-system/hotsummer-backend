package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "product_characteristics_id")
    private int productCharacteristicsId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "characteristics_id", referencedColumnName = "characteristics_id")
    private Characteristic characteristic;
}
