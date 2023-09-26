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

import java.util.Date;

@Entity
@Table(name = "TestHistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_history_id")
    private int testHistoryId;
    @Column(name = "date")
    private Date date;
    @Column(name = "skin_type")
    private String skinType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserAct userAct;
}
