package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Characteristic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristics_id")
    private int characteristicsId;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "characteristic", cascade = CascadeType.ALL)
    private List<ProductCharacteristics> productCharacteristics;
}
