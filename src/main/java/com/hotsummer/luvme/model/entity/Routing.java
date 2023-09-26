package com.hotsummer.luvme.model.entity;

import com.hotsummer.luvme.model.enums.RoutingType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Routing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Routing {
    @Id
    @Column(name = "routing_id")
    private UUID routing_id;
    @Column(name = "routing_type")
    private String routingType;
    @Column(name = "date")
    private Date date;
    @Column(name = "description")
    private String description;
    @Column(name = "is_done")
    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserTbl userAct;
    @ManyToOne
    @JoinColumn(name = "routing_step_id", referencedColumnName = "routing_step_id")
    private RoutingStep routingStep;
}
