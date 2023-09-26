package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "SuitableSkinType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuitableSkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product_skin_type_id", cascade = CascadeType.ALL)
    private List<ProductSkinType> productSkinTypes;

}
