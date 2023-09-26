package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Favorite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorite {
    @Id
    @Column(name = "favorite_id")
    private UUID favoriteId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "add_date")
    private Date addDate;
}
