package com.hotsummer.luvme.model.entity;

import com.hotsummer.luvme.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UserAct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAct {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "is_premium")
    private Boolean isPremium;
    @Column(name = "start_premium_date")
    private Date startPremiumDate;
    @Column(name = "end_premium_date")
    private Date endPremiumDate;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    @OneToMany(mappedBy = "history_id", cascade = CascadeType.ALL)
    private List<TestHistory> testHistories;
    @OneToMany(mappedBy = "routing_id", cascade = CascadeType.ALL)
    private Routing routing;
    @OneToMany(mappedBy = "transaction_id" , cascade = CascadeType.ALL)
    private List<Transactions> transactions;
}
