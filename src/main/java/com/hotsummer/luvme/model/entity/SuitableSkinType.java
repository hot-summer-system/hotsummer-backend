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
    @Column(name = "suitable_skin_type_id")
    private int suitableSkinTypeId;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "suitableSkinType", cascade = CascadeType.ALL)
    private List<ProductSkinType> productSkinTypes;

}
