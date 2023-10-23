package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ProductManual")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductManual {
    @Id
    @Column(name = "product_manual_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productManualId;
    @Column(name = "order_step")
    private int orderStep;
    @Column(name = "name_step")
    private String nameStep;
    @Column(name = "description", columnDefinition = "nvarchar(max)")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
