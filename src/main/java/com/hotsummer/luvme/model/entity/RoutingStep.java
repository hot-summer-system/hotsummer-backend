package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id", referencedColumnName = "routing_id")
    private Routing routing;
}
