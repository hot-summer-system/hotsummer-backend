package com.hotsummer.luvme.model.entity;

import com.hotsummer.luvme.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UserTbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserTbl {
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
    @Column(name = "status")
    private String status;
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
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL)
    private List<TestHistory> testHistories;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL)
    private List<Routing> routings;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL)
    private List<Transactions> transactions;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL)
    private List<Favorite> favorites;
}
