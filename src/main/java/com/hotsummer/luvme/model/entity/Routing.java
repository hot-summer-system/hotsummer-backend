package com.hotsummer.luvme.model.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "date_reminder")
    private String dateReminder;
    @Column(name = "is_done")
    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserTbl userAct;
    @OneToMany(mappedBy = "routing", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RoutingStep> routingSteps;
}
