package com.hotsummer.luvme.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "RoutingStep")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutingStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routing_step_id")
    private int routingStepId;
    @Column(name = "product_id")
    private String productId;

    @ManyToOne
    @JoinColumn(name = "routing_id", referencedColumnName = "routing_id")
    private Routing routing;
}
